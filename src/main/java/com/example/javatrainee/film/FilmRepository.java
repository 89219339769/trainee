package com.example.javatrainee.film;


import com.example.javatrainee.film.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
