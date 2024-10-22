package org.example.lifesafe.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        return "register";
    }
}

