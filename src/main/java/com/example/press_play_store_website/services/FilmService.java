package com.example.press_play_store_website.services;

import com.example.press_play_store_website.entities.tables.FilmEntity;

public class FilmService {
    public void update(FilmEntity updatedFilm, FilmEntity film) {
        film.setTitle(updatedFilm.getTitle());
    }
}
