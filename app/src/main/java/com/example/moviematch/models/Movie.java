package com.example.moviematch.models;

public class Movie {
    private String title;
    private String poster_path;
    private String overview;
    private String release_date;

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return "https://image.tmdb.org/t/p/original"+poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return release_date;
    }
}
