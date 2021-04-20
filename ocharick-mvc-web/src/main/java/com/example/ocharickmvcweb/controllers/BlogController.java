package com.example.ocharickmvcweb.controllers;

import com.example.ocharickmvcweb.models.AllPost;
import com.example.ocharickmvcweb.repo.AllPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @Autowired
    private AllPostRepository allPostRepository;

    @GetMapping("/about")       //Контроллер для отслеживания url страницы блога web-ресурса
    public String blogMain(Model model) {
        model.addAttribute("title", "Страница блога");
        Iterable<AllPost> allPosts = allPostRepository.findAll();
        model.addAttribute("allPosts", allPosts);

        return "about";
    }

}
