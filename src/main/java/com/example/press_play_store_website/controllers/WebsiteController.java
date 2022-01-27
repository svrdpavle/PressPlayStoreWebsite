package com.example.press_play_store_website.controllers;

import com.example.press_play_store_website.entities.views.FilmListEntity;
import com.example.press_play_store_website.repositories.FilmListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebsiteController {
    private final FilmListRepository filmListRepository;
    //private final FilmService filmService = new FilmService();

    @Autowired
    public WebsiteController(FilmListRepository filmListRepository) {
        this.filmListRepository = filmListRepository;
    }

    @GetMapping("/film")
    public String getAllFilms(Model model) {
        model.addAttribute("film", filmListRepository.findAll());
        return "film";
    }

    @GetMapping("/view-film/{id}")
    public String viewFilm(@PathVariable("id") Integer id, Model model) {
        FilmListEntity filmListEntity = filmListRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Film ID: " + id));
        model.addAttribute("film", filmListEntity);
        return "view-film";
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
