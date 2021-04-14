package com.itvillage.ecommaz.controller.users;


import com.itvillage.ecommaz.services.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@AllArgsConstructor
public class
HomePageController {

    private final ContactService contactService;

    @GetMapping("/")
    public ModelAndView getHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contactInfoResponse", contactService.getContactDetails());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
