package com.example.moviematch.models;

import android.net.Uri;

public class Movie {
    private String title;
    private Uri posterPath;
    private String overview;
    private String releaseDate;

    public Movie(String title, Uri posterPath, String overview, String releaseDate) {
        this.title = title;
        this.posterPath = posterPath;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public Uri getPosterPath() {
        return posterPath;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
