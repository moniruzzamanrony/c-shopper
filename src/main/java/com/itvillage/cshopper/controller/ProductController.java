package com.itvillage.cshopper.controller;


import com.itvillage.cshopper.domain.Product;
import com.itvillage.cshopper.dto.request.LoginForm;
import com.itvillage.cshopper.repository.ProductRepository;
import com.itvillage.cshopper.services.AuthService;
import com.itvillage.cshopper.services.ProductService;
import com.itvillage.cshopper.util.FileUploadUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class ProductController {
    @Autowired
    private final ProductRepository productRepository;
    private final ProductService productService;
    private final AuthService authService;

    @GetMapping("/{productId}")
    public ModelAndView getProductDetailsBypId(@PathVariable("productId") String productId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", productId);
        modelAndView.setViewName("product-details");


        return modelAndView;
    }



    @PostMapping("/product/save")
    public RedirectView saveUser(Product photo,
                                 @RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();

        photo.setId(id);
        photo.setPhotos(fileName);
        Product savedUser = productRepository.save(photo);

        String uploadDir = "user-photos/" + savedUser.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return new RedirectView("/", true);
    }

    @GetMapping("/product1")
    public ModelAndView getHomePage()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPageAfterlogin");


        return modelAndView;
    }



    @RequestMapping("/view")
    public String loginUser2(@ModelAttribute Product product, HttpServletRequest request) {

        request.setAttribute("listall", productService.show());
        return "ProductDetailsView";
    }






    @GetMapping("/ordernow/{id}")
    public ModelAndView ordernow(HttpServletRequest request,@RequestParam String id)
    {

        ModelAndView modelAndView = new ModelAndView();
        request.setAttribute("listall", productService.findAllById(id));

        modelAndView.setViewName("order");

        return modelAndView;
    }

    @GetMapping("/productview/{id}")
    public ModelAndView getHomePage(HttpServletRequest request,@RequestParam String id)
    {

        ModelAndView modelAndView = new ModelAndView();
        request.setAttribute("listall", productService.findAllById(id));

        modelAndView.setViewName("ProductDetailsView");

        return modelAndView;
    }



    /*   @GetMapping("/h")
    public ModelAndView getHomePage(HttpServletRequest request)
    {
        ModelAndView modelAndView = new ModelAndView();
        request.setAttribute("listall", productService.show());

        modelAndView.setViewName("ProductDetailsView");

        return modelAndView;
    }*/


    @GetMapping("/productview")
    public ModelAndView productview(@RequestParam String id, HttpServletRequest request)
    {
        ModelAndView modelAndView = new ModelAndView();
        request.setAttribute("listall", productService.editProduct(id));

        modelAndView.setViewName("ProductDetailsView");

        return modelAndView;
    }


    @RequestMapping("/edit/{id}")
    public ModelAndView showUpdateForm(@PathVariable("id") String id ,HttpServletRequest request) {
        System.out.println("this id is ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,," +id);

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        ModelAndView modelAndView = new ModelAndView();

        request.setAttribute("listall", product);
        modelAndView.setViewName("update");

        return modelAndView;
    }



}
