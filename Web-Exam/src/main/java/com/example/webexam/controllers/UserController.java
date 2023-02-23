package com.example.webexam.controllers;

import com.example.webexam.models.dtos.UserLoginDTO;
import com.example.webexam.models.dtos.UserRegistrationDTO;
import com.example.webexam.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @ModelAttribute("registrationDTO")
    public UserRegistrationDTO initRegistrationDTO() {
        return new UserRegistrationDTO();

    }

    @ModelAttribute("loginDTO")
    public UserLoginDTO initLoginDTO() {
        return new UserLoginDTO();

    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistrationDTO registrationDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !this.userService.register(registrationDTO)) {
            redirectAttributes.addFlashAttribute("registrationDTO", registrationDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.registrationDTO", bindingResult);

            return "redirect:/register";
        }

        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    private String login(@Valid UserLoginDTO loginDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.loginDTO", bindingResult);

            return "redirect:/login";
        }
        if (!this.userService.login(loginDTO)) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("badCredentials", true);

            return "redirect:/login";
        }
        return "redirect:/home";
    }
    @GetMapping("/logout")
    public String logout() {
        if(this.userService.isLogged()) {
            this.userService.logout();
        }
        return "redirect:/";
    }


}
