package com.example.shoppinglist.controllers;

import com.example.shoppinglist.utils.LoggedUser;
import com.example.shoppinglist.services.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final AuthService authService;
    private final LoggedUser loggedUser;

    public HomeController(AuthService authService, LoggedUser loggedUser) {
        this.authService = authService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/")
    private String index() {
        return "index";
    }

    @GetMapping("/home")
    private String home() {
      return "home";

    }
}
