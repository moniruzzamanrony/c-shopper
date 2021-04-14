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
public class PageController {

    @GetMapping("/page-not-found")
    public ModelAndView getContactPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("404");
        return modelAndView;
    }
}
