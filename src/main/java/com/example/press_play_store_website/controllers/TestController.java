package com.example.press_play_store_website.controllers;

import com.example.press_play_store_website.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    private final ActorRepository actorRepository;

    @Autowired
    public TestController(ActorRepository actorRepository ) {
        this.actorRepository = actorRepository;
    }

    @GetMapping("/test")
    public String getAllFilms(Model model) {
        model.addAttribute("actor", actorRepository.findAll());
        return "test";
    }
}
