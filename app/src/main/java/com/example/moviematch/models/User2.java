package com.example.moviematch.models;

import java.util.ArrayList;
import java.util.List;

public class User2 {
    private static User2 instance;
    List<Movie> watchList;
    List<Movie> watchedMovies;
    List<Movie> avoidList;

    public void addToWatchList(Movie movie) {
        watchList.add(movie);
    }

    public void addWatchedMovie(Movie movie) {
        watchedMovies.add(movie);
    }

    public void addToAvoidList(Movie movie) {
        avoidList.add(movie);
    }

    public List<Movie> getWatchList() {
        return watchList;
    }

    public void setWatchList(List<Movie> watchList) {
        this.watchList = watchList;
    }

    public List<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(List<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    public List<Movie> getAvoidList() {
        return avoidList;
    }

    public void setAvoidList(List<Movie> avoidList) {
        this.avoidList = avoidList;
    }

    private User2() {
        watchList = new ArrayList<>();
        watchedMovies = new ArrayList<>();
        avoidList = new ArrayList<>();
    }

    public static synchronized User2 getInstance() {
        if (instance == null) {
            instance = new User2();
        }
        return instance;
    }
}
