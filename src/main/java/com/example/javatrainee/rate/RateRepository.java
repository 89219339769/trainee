package com.example.javatrainee.rate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface RateRepository extends JpaRepository<Rate, Long> {

    Collection<Rate> findAllByFilmIdIs(long filmId);

    Rate findRateByAuthor_Id(long userId);
}





