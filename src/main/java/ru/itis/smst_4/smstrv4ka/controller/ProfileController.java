package ru.itis.smst_4.smstrv4ka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.smst_4.smstrv4ka.MySession.MySession;
import ru.itis.smst_4.smstrv4ka.repository.UsersRepository;
import ru.itis.smst_4.smstrv4ka.service.UsersService;

@Controller
public class ProfileController {
    @Autowired
    UsersService usersService;
    @Autowired
    UsersRepository userRepository;
    @Autowired
    MySession session;

    @GetMapping("/profile")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView profilePage() {
        ModelAndView model = new ModelAndView("profile_page");
        System.out.println(session.getUser().getPosts());
        model.addObject("user", session.getUser());
        return model;
    }

    @GetMapping("/profile/{userId}")
    @PreAuthorize("hasAuthority('Admin')")
    public ModelAndView profilePage(@PathVariable Long userId) {
        ModelAndView model = new ModelAndView("profile_page");
        model.addObject("user", userRepository.findById(userId).get());
        return model;
    }
}
