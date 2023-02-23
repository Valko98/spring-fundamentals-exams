package com.example.webexam.controllers;

import com.example.webexam.models.dtos.OfferDTO;
import com.example.webexam.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String loggedOutIndex() {
        if(this.userService.isLogged()) {
            return "redirect:/home";
        }
        return "index";
    }
    @GetMapping("home")
    public String loggedInIndex() {
        if(!this.userService.isLogged()) {
            return "redirect:/";
        }
        return "home";
    }
}
