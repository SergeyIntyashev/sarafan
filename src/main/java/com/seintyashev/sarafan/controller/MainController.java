package com.seintyashev.sarafan.controller;

import com.seintyashev.sarafan.domain.User;
import com.seintyashev.sarafan.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@CrossOrigin("*")
@Controller
@RequestMapping
public class MainController {

    @Value("${spring.profiles.active}")
    private String profile;

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping
    public String main(Model model, @AuthenticationPrincipal User user){

        HashMap<Object, Object> data = new HashMap<>();

        if (user != null) {
            data.put("profile", user);
            data.put("messages", messageRepo.findAll());
        }

        model
            .addAttribute("frontendData", data)
            .addAttribute("isDevMode", "dev".equals(profile));
        return "index";
    }
}
