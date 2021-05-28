package com.itvillage.cshopper.controller;


import com.itvillage.cshopper.dto.request.EmailBodyForm;
import com.itvillage.cshopper.dto.request.LoginForm;
import com.itvillage.cshopper.dto.request.SignUpForm;
import com.itvillage.cshopper.repository.MailService;
import com.itvillage.cshopper.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    MailService mailService;

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
    public ModelAndView authenticateUserLogin(@ModelAttribute LoginForm loginForm) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminPageAfterlogin");
        ResponseEntity.ok(authService.signIn(loginForm));
        return modelAndView;

    }


    @PostMapping("/send/email")
    public void SendEmail(@ModelAttribute EmailBodyForm emailBodyForm) {
        mailService.sendMail(emailBodyForm.getUsername(),
                emailBodyForm.getExampleInputAddress(),emailBodyForm.getExampleInputEmail1(),
                emailBodyForm.getPhone(),emailBodyForm.getProductPrice(),emailBodyForm.getProductTotal());
    }

}
