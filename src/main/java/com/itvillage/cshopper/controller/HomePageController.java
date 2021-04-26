package com.itvillage.cshopper.controller;


import com.itvillage.cshopper.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@AllArgsConstructor
public class HomePageController {

    private final ProductService productService;

    @GetMapping("/")
    public ModelAndView getHomePage()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");


        return modelAndView;
    }
}
