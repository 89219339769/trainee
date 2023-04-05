package com.example.javatrainee.film.model;


import org.springframework.stereotype.Component;

@Component
public class Mapper {


    public static FilmDto toFilmDto (Film film) {
        return FilmDto.builder()
                .id(film.getId())
                .name(film.getName())
                .description(film.getDescription())
                .averageRates(0.0)
                .build();
    }


}
