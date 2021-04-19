package com.example.ocharickmvcweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {
    @GetMapping("/catalogs")       //Контроллер для отслеживания url страницы контактов web-ресурса
    public String catalogs(Model model) {
        model.addAttribute("title", "Страница каталога");
        return "catalog";
    }
}
