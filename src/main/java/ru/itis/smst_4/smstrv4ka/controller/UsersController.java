package ru.itis.smst_4.smstrv4ka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.smst_4.smstrv4ka.service.UsersService;


@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('Admin')")
    public ModelAndView getUsersPage() {
        ModelAndView view = new ModelAndView("user_page");
        view.addObject("users", usersService.getAllUsers(0, 10, "Id"));
        return view;
    }

    @GetMapping("/wall/{userId}")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView getUserWall(@PathVariable Long userId){
        ModelAndView view = new ModelAndView("user_wall");
        view.addObject("user", usersService.getUser(userId));
        return view;

    }
}

