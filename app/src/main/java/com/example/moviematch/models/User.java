package com.example.moviematch.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    String username;
    List<Movie> watchList;
    List<Movie> watchedMovies;
    List<Movie> avoidList;

    public User(String username) {
        watchList = new ArrayList<>();
        watchedMovies = new ArrayList<>();
        avoidList = new ArrayList<>();
        this.username = username;
    }

    public void addToWatchList(Movie movie) {
        watchList.add(movie);
    }

    public void addWatchedMovie(Movie movie) {
        watchedMovies.add(movie);
    }

    public void addToAvoidList(Movie movie) {
        avoidList.add(movie);
    }
}
