package com.itvillage.cshopper.controller;


import com.itvillage.cshopper.dto.request.LoginForm;
import com.itvillage.cshopper.dto.request.SignUpForm;
import com.itvillage.cshopper.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @GetMapping("/login")
    public ModelAndView getLoginPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @PostMapping("/sign_up")
    public ModelAndView authenticateUserSignUp(@ModelAttribute SignUpForm signUpForm) {

        ResponseEntity.ok(authService.signUp(signUpForm));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @PostMapping("/login_user")
    public ResponseEntity<?> authenticateUserLogin(@ModelAttribute LoginForm loginForm) {

        return  ResponseEntity.ok(authService.signIn(loginForm));
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("product-details");
//        return modelAndView;
    }
}
