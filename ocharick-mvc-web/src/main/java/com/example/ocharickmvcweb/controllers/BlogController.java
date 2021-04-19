package com.example.ocharickmvcweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @GetMapping("/about")       //Контроллер для отслеживания url страницы блога web-ресурса
    public String blogMain(Model model) {
        model.addAttribute("title", "Страница блога");
        return "about";
    }
}
