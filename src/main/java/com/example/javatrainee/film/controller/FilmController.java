package com.example.javatrainee.film.controller;


import com.example.javatrainee.film.FilmService;
import com.example.javatrainee.film.model.Film;
import com.example.javatrainee.film.model.FilmDto;
import com.example.javatrainee.rate.Rate;
import com.example.javatrainee.rate.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;

    private final RateService rateService;



    @PostMapping
    public Film create(@RequestBody Film film) {
        return filmService.save(film);
    }


    @PostMapping("/{filmId}/rate")
    public Rate add(@RequestHeader("X-Sharer-User-Id") Long userId,
                    @PathVariable Long filmId,
                    @RequestBody Rate rate) {
        return rateService.addRate(userId, filmId, rate);
    }


    @GetMapping("/{id}")
    public FilmDto findFilmById(@PathVariable Long id) {
        return filmService.get(id);

    }



    @GetMapping
    public ResponseEntity<Page<FilmDto>> getAll(@RequestParam (defaultValue = "0") int from,
                                                @RequestParam (defaultValue = "100") int size,
                                                Pageable pageable) {
        Page<FilmDto> allFilms =  filmService.getAllFilms(from, size, pageable);
        allFilms.getTotalElements();
        allFilms.getTotalPages();


        return ResponseEntity.ok( allFilms);
    }















    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        filmService.delete(id);
    }
}
