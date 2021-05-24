package com.itvillage.cshopper.controller;


import com.itvillage.cshopper.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@RestController
@AllArgsConstructor
public class HomePageController {

    private final ProductService productService;

    @GetMapping("/")
    public ModelAndView getHomePage(HttpServletRequest request)
    {
        ModelAndView modelAndView = new ModelAndView();
        request.setAttribute("listall", productService.show());

        modelAndView.setViewName("index");

        return modelAndView;
    }


}
