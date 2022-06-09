package com.myapp.app.model;

import java.util.List;

public class TmdbSearchResult {

    List<TmdbMovie> results;

    public List<TmdbMovie> getResults() {
        return results;
    }

    public void setResults(List<TmdbMovie> results) {
        this.results = results;
    }


}
