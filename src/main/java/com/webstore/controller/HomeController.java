package com.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/")
@Controller
public class HomeController {
    @RequestMapping
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome!");
        model.addAttribute("shop", "Store");
        return "welcome";
    }

    @RequestMapping("hi")
    public String hi(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("greeting", "Welcome");
        redirectAttributes.addFlashAttribute("shop", "Store");
        return "redirect:/redirect_welcome_message/";
    }

    @RequestMapping("redirect_welcome_message")
    public String redirectWelcomeMessage() {
        return "welcome";
    }
}
