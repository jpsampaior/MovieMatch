package com.example.moviematch.models;

public class Movie {
    private String title;
    private String posterPath;
    private String overview;
    private String releaseDate;

    public Movie(String title, String posterPath, String overview, String releaseDate) {
        this.title = title;
        this.posterPath = posterPath;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
