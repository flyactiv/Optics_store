package com.example.ocharickmvcweb.controllers;

import com.example.ocharickmvcweb.models.Catalog;
import com.example.ocharickmvcweb.repo.catalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {

    @Autowired
    private com.example.ocharickmvcweb.repo.catalogRepository catalogRepository;

    @GetMapping("/catalogs")       //Контроллер для отслеживания url страницы контактов web-ресурса
    public String catalogs(Model model) {
        Iterable<Catalog> catalogs= catalogRepository.findAll();
        model.addAttribute("catalogs", catalogs);
        model.addAttribute("title", "Страница каталога");
        return "catalog";
    }


}
