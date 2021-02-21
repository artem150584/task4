package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecentController {

    @GetMapping("/books/recent")
    public String recentPage(Model model) {
        model.addAttribute("recentActive", "true");
        return "books/recent";
    }
}
