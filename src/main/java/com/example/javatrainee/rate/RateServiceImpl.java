package com.example.javatrainee.rate;


import com.example.javatrainee.exceptions.NotFoundException;
import com.example.javatrainee.film.FilmRepository;
import com.example.javatrainee.film.model.Film;
import com.example.javatrainee.user.User;
import com.example.javatrainee.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor

public class RateServiceImpl implements RateService {

    private final  RateRepository rateRepository;

    private final UserRepository userRepository;

    private final FilmRepository filmRepository;

    @Override
    public Rate addRate(Long userId, Long filmId, Rate rate) {
        User user = userRepository.findById(userId)
                                  .orElseThrow(() -> new NotFoundException("не найден пользователь с id: " + userId));

        Film film = filmRepository.findById(filmId)
                                  .orElseThrow(() -> new NotFoundException("не найден пользователь с id: " + userId));

        rate.setAuthor(user);

        rate.setFilm(film);

        return rateRepository.save(rate);
    }
}
