package com.example.press_play_store_website.repositories;

import com.example.press_play_store_website.entities.views.FilmListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmListRepository extends JpaRepository<FilmListEntity, Integer> {
}
