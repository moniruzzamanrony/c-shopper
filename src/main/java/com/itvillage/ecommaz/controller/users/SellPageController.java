package com.itvillage.ecommaz.controller.users;


import com.itvillage.ecommaz.constant.BaseAPIConstant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@AllArgsConstructor
@RequestMapping(BaseAPIConstant.PUBLIC_API)
public class SellPageController {


    @GetMapping("/cart")
    public ModelAndView getCartage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cart");
        return modelAndView;
    }

    @GetMapping("/checkout")
    public ModelAndView getCheckoutPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("checkout");
        return modelAndView;
    }
}
