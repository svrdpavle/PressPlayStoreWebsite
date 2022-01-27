package com.example.press_play_store_website.controllers;

import com.example.press_play_store_website.repositories.ActorRepository;
import com.example.press_play_store_website.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    private final AddressRepository addressRepository;

    @Autowired
    public TestController(AddressRepository addressRepository ) {
        this.addressRepository = addressRepository;
    }

    @GetMapping("/test")
    public String getAllFilms(Model model) {
        model.addAttribute("address", addressRepository.findAll());
        return "test";
    }
}
