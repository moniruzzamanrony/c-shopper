package com.itvillage.cshopper.controller;


import com.itvillage.cshopper.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ModelAndView getProductDetailsBypId(@PathVariable("productId") String productId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", productId);
        modelAndView.setViewName("product-details");


        return modelAndView;
    }
}
