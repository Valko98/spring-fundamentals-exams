package com.example.webexam.controllers;

import com.example.webexam.models.dtos.OfferDTO;
import com.example.webexam.services.OfferService;
import com.example.webexam.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OfferController {

    @ModelAttribute("offerDTO")
    public OfferDTO initOfferDTO() {
        return new OfferDTO();
    }

    private final UserService userService;
    private final OfferService offerService;

    public OfferController(UserService userService, OfferService offerService) {
        this.userService = userService;
        this.offerService = offerService;
    }


    @GetMapping("/offer/add")
    public String offer() {
        if(this.userService.isLogged()) {
            return "offer-add";
        }
        return "redirect:/login";
    }
    @PostMapping("/offer/add")
    public String addOffer(@Valid OfferDTO offerDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if(!this.userService.isLogged()) {
            return "redirect:/";

        }
        if(bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerDTO", offerDTO);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.offerDTO", bindingResult);

            return "redirect:/offer/add";
        }
        return "redirect:/home";

    }
}
