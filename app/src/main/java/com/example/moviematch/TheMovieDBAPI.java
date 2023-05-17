package com.example.moviematch;

import com.example.moviematch.models.Movie;
import com.example.moviematch.models.MovieListResponse;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.List;

public class TheMovieDBAPI {
    private static final String API_KEY = "2f3597a16a6d886246818433956047aa";

    private OkHttpClient client;
    private Gson gson;

    public TheMovieDBAPI() {
        client = new OkHttpClient();
        gson = new Gson();
    }

    public List<Movie> getPopularMovies() throws Exception {
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + API_KEY;
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String json = response.body().string();

        // Fazer a conversão do JSON para uma lista de objetos Java
        MovieListResponse movieListResponse = gson.fromJson(json, MovieListResponse.class);

        // Retornar a lista de filmes populares
        return movieListResponse.getResults();
    }
}
