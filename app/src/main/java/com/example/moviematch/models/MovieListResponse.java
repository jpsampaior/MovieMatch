package com.example.moviematch.models;

import java.util.ArrayList;
import java.util.List;

public class MovieListResponse {
    private List<Movie> results;

    public MovieListResponse() {
        results = new ArrayList<>();
    }

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }

    public void setNewMoviesToList(List<Movie> lista) {
        results.addAll(lista);
    }
}
