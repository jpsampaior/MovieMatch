package com.example.moviematch.apiConnection;

import android.os.AsyncTask;

import com.example.moviematch.models.Movie;
import com.example.moviematch.models.MovieListResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TMDBconnection extends AsyncTask<Void, Void, List<Movie>> {
    private static final String API_KEY = "2f3597a16a6d886246818433956047aa";
    private OkHttpClient client;
    private Gson gson;
    private String json;
    private int page;
    private MovieListResponse movieListResponse;
    public TMDBconnection() {
        this.client = new OkHttpClient();
        this.gson = new Gson();
        this.page = 0;
        this.movieListResponse = new MovieListResponse();
    }

    protected List<Movie> doInBackground(Void... voids) {
        while(page<5) {
            String url = "https://api.themoviedb.org/3/discover/movie?api_key="+API_KEY+"&with_genres=28&page="+(++page);
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            try {
                json = null;
                Response response = client.newCall(request).execute();
                json = response.body().string();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            MovieListResponse list = gson.fromJson(json, MovieListResponse.class);
            movieListResponse.setNewMoviesToList(list.getResults());
        }

        return movieListResponse.getResults();
    }
}
