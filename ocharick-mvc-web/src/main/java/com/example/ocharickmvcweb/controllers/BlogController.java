package com.example.ocharickmvcweb.controllers;

import com.example.ocharickmvcweb.models.AllPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {

    @Autowired
    private com.example.ocharickmvcweb.repo.allPostRepository allPostRepository;

    @GetMapping("/about")       //Контроллер для отслеживания url страницы блога web-ресурса
    public String blogMain(Model model) {
        model.addAttribute("title", "Страница блога");
        Iterable<AllPost> allPosts = allPostRepository.findAll();
        model.addAttribute("allPosts", allPosts);
        return "about";
    }

    @GetMapping("/addPost")       //Контроллер для отслеживания url страницы для добавления постов в блог web-ресурса
    public String addBlog(Model model) {
        model.addAttribute("title", "Страница добавления постов в блог");
        return "addPost";
    }

    @PostMapping("/addPost")
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
        AllPost post = new AllPost(title,anons,full_text);
        allPostRepository.save(post);
        return "redirect:/about";
    }


}
