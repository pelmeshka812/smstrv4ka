package ru.itis.smst_4.smstrv4ka.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

    @GetMapping("/signIn")
    public String getSignInPage() {
        return "sign_in";
    }

}