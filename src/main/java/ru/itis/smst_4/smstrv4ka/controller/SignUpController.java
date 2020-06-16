package ru.itis.smst_4.smstrv4ka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.smst_4.smstrv4ka.dto.SignUpDto;
import ru.itis.smst_4.smstrv4ka.service.SignUpService;



@Controller
public class SignUpController {
    @Autowired
    private SignUpService service;

    @GetMapping("/signUp")
    @PreAuthorize("permitAll()")
    public String getSignUpPage() {
        return "sign_up";
    }

    @PostMapping("/signUp")
    @PreAuthorize("permitAll()")
    public String signUp(SignUpDto form) {
        service.signUp(form);
        return "redirect:/signIn";
    }

}
