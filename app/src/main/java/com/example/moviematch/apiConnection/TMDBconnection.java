package com.example.moviematch.apiConnection;

import android.os.AsyncTask;
import android.util.Log;

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

    public TMDBconnection() {
        this.client = new OkHttpClient();
        this.gson = new Gson();
    }

    protected List<Movie> doInBackground(Void... voids) {
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + API_KEY;
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

        //Log.d("filmes", )

        // Fazer a conversão do JSON para uma lista de objetos Java
        MovieListResponse movieListResponse = gson.fromJson(json, MovieListResponse.class);

        return movieListResponse.getResults();
    }
}
