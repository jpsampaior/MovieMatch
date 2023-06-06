package com.example.moviematch.models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class UserSingleton {
    private static UserSingleton instance;
    List<Movie> watchList;
    List<Movie> watchedMovies;
    List<Movie> avoidList;
    List<Movie> randomList;

    public List<Movie> getRandomList() {
        return randomList;
    }

    public void setRandomList(List<Movie> randomList) throws ExecutionException, InterruptedException {
        this.randomList = randomList;
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

    private UserSingleton() {
        watchList = new ArrayList<>();
        watchedMovies = new ArrayList<>();
        avoidList = new ArrayList<>();
    }

    public static synchronized UserSingleton getInstance() {
        if (instance == null) {
            instance = new UserSingleton();
        }
        return instance;
    }
}
