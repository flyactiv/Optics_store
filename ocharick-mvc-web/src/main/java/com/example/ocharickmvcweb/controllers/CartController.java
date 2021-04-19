package com.example.ocharickmvcweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
    @GetMapping("/cart")       //Контроллер для отслеживания url страницы корзины web-ресурса
    public String cart(Model model) {
        model.addAttribute("title", "Страница корзины");
        return "work";
    }
}
