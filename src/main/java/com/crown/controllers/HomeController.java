package com.crown.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("greeting", "Welcome to Shopping Store!");
        model.addAttribute("tagline", "An amazing webstore");

        return "forward:/welcome/greeting";
    }

    @RequestMapping("/welcome/greeting")
    public String greeting(Model model) {
        return "welcome";
    }
}
