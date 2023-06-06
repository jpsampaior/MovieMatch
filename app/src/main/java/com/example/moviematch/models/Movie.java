package com.example.moviematch.models;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.example.moviematch.apiConnection.imageBitmapTask;

import java.util.concurrent.ExecutionException;

public class Movie {
    private String title;
    private String poster_path;
    private String overview;
    private String release_date;
    private Bitmap img_bitmap;

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

    public Bitmap getImg_bitmap() {
        return img_bitmap;
    }

    public void setImg_bitmap() throws ExecutionException, InterruptedException {
        this.img_bitmap = new imageBitmapTask().execute(getPosterPath()).get();
    }
}
