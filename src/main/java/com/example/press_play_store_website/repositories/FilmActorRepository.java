package com.example.press_play_store_website.repositories;

import com.example.press_play_store_website.entities.tables.FilmActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmActorRepository extends JpaRepository<FilmActorEntity, Integer> {
}
