package com.dev.cinema.service;

import com.dev.cinema.model.MovieSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieSessionService {
    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession add(MovieSession session);

    MovieSession update(MovieSession movieSession);

    Optional<MovieSession> get(Long id);

    void delete(Long id);
}
