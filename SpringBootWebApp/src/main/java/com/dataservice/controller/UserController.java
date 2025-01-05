package com.dataservice.controller;

import com.dataservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dataservice.dao.UserInput;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("texts", userService.getUserInputs());
        return "index";
    }

    @PostMapping("/submit")
    public String submit(@RequestParam String content) {
        UserInput text = new UserInput();
        text.setContent(content);
        userService.saveUserInput(text);
        return "redirect:/";
    }

  
}