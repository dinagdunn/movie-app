package com.myapp.app.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.myapp.app.model.TmdbMovie;
import com.myapp.app.service.TmdbApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    TmdbApiService apiService;

    @GetMapping("/movie/{id}")
    @PreAuthorize("hasRole('USER')")
    public TmdbMovie getMovie(@PathVariable(value = "id") String movieId) {
        return apiService.getMovie(movieId);
    }

    @GetMapping("/movie/now")
    @PreAuthorize("hasRole('USER')")
    public List<TmdbMovie> getNowPlaying() throws JsonProcessingException {
        return apiService.getNowPlaying();
    }

    @GetMapping("/search/movie")
    @PreAuthorize("hasRole('USER')")
    public List<TmdbMovie> searchMovies(@RequestParam String query) {
        return apiService.searchMovies(query);
    }
}
