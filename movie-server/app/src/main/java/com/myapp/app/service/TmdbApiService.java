package com.myapp.app.service;

import com.myapp.app.model.TmdbMovie;
import com.myapp.app.model.TmdbSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TmdbApiService {

    @Autowired
    RestTemplate restTemplate;

    private static String API_KEY = "a27a7b4e4ea32c39caa82c593ea27b5c";

    public TmdbMovie getMovie(String movieId) {
        String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + API_KEY;
        return restTemplate.getForObject(url, TmdbMovie.class);
    }

    public List<TmdbMovie> getNowPlaying() {
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=" + API_KEY;
        TmdbSearchResult searchResult = restTemplate.getForObject(url, TmdbSearchResult.class);
        assert searchResult != null;
        return searchResult.getResults();
    }

    public List<TmdbMovie> searchMovies(String query) {
        String url = "https://api.themoviedb.org/3/search/movie?api_key=" + API_KEY + "&language=en-US&query=" + query;
        TmdbSearchResult searchResult = restTemplate.getForObject(url, TmdbSearchResult.class);
        assert searchResult != null;
        return searchResult.getResults();
    }
}
