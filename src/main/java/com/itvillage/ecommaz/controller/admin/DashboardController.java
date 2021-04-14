package com.itvillage.ecommaz.controller.admin;


import com.itvillage.ecommaz.constant.BaseAPIConstant;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@AllArgsConstructor
@RequestMapping(BaseAPIConstant.PRIVATE_API)
public class DashboardController {


    @GetMapping("/dashboard")
    public ModelAndView getAdminDashboard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard-admin");
        return modelAndView;
    }

    @GetMapping("/registration")
    public ModelAndView getRegistrationPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("account");
        return modelAndView;
    }
}
