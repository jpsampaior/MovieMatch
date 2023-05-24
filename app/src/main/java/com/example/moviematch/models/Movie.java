package com.example.moviematch.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Movie {
    private String title;
    private String poster_path;
    private String overview;
    private String release_date;

    public Movie(String title, String poster_path, String overview, String release_date) {
        this.title = title;
        this.poster_path = "https://image.tmdb.org/t/p/original"+poster_path;
        this.overview = overview;
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return release_date;
    }

    public Bitmap getImageBitmap() {
        Bitmap bm = null;
        try {
            URL aURL = new URL(getPosterPath());
            URLConnection conn = aURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {
            Log.e("error", "Error getting bitmap", e);
        }
        return bm;
    }
}
