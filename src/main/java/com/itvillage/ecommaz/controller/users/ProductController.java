package com.itvillage.ecommaz.controller.users;


import com.itvillage.ecommaz.constant.BaseAPIConstant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@AllArgsConstructor
@RequestMapping(BaseAPIConstant.PUBLIC_API + "/products")
public class ProductController {

    @GetMapping()
    public ModelAndView getProductPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("product");
        return modelAndView;
    }

    @GetMapping("/{productId}")
    public ModelAndView getProductDetailsBypId(@PathVariable("productId") String productId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", productId);
        modelAndView.setViewName("product-detail");


        return modelAndView;
    }
}
