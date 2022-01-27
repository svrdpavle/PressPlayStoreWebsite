package com.example.press_play_store_website.controllers;

import com.example.press_play_store_website.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilmController {
    private final FilmRepository filmRepository;
    //private final FilmService filmService = new FilmService();

    @Autowired
    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping("/film")
    public String getAllFilms(Model model) {
        model.addAttribute("film", filmRepository.findAll());
        return "film";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/home")
    public String home() {
        return "index";
    }
}
