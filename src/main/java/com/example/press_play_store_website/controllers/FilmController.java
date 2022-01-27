package com.example.press_play_store_website.controllers;

import com.example.press_play_store_website.repositories.FilmListRepository;
import com.example.press_play_store_website.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilmController {
    private final FilmListRepository filmListRepository;
    //private final FilmService filmService = new FilmService();

    @Autowired
    public FilmController(FilmListRepository filmListRepository) {
        this.filmListRepository = filmListRepository;
    }

    @GetMapping("/film")
    public String getAllFilms(Model model) {
        model.addAttribute("film", filmListRepository.findAll());
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
