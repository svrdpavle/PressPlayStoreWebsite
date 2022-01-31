package com.example.press_play_store_website.repositories;

import com.example.press_play_store_website.entities.tables.FilmCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmCategoryRepository extends JpaRepository<FilmCategoryEntity, Integer> {
}
