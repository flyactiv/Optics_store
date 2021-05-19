package com.example.ocharickmvcweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ContactsController {
    @GetMapping("/contacts")       //Контроллер для отслеживания url страницы контактов web-ресурса
    public String contacts(Model model) {
        model.addAttribute("title", "Страница контактов");
        return "contact";
    }

}
