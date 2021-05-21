package com.example.ocharickmvcweb.controllers;

import com.example.ocharickmvcweb.models.MyContacts;
import com.example.ocharickmvcweb.models.NewOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
    @Autowired
    public JavaMailSender emailSender;
    @Autowired
    private com.example.ocharickmvcweb.repo.orderRepository orderRepository;

    @GetMapping("/checkout")       //Контроллер для отслеживания url страницы контактов web-ресурса
    public String checkout(Model model) {
        return "checkout";
    }

    @PostMapping("/work")       //Контроллер для отслеживания url страницы контактов web-ресурса
    public String orderAdd(@RequestParam String orderDetail, @RequestParam String email, @RequestParam String name, Model model) {
        NewOrders newOrders = new NewOrders(orderDetail,email,name);
        orderRepository.save(newOrders);

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject("Information for your order");
        message.setText(orderDetail + "'\n'Please state your name when you receive the parcel");


        // Send Message!
        this.emailSender.send(message);

        return "redirect:/checkout";
    }

}
