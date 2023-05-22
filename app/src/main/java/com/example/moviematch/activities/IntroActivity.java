package com.example.moviematch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moviematch.R;
import com.example.moviematch.apiConnection.TMDBconnection;
import com.example.moviematch.models.Movie;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class IntroActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity);

        List<Movie> lista = null;

        try {
            lista = new TMDBconnection().execute().get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (Movie movie : lista) {
            Log.d("filmes2",movie.getTitle());
        }
    }

    public void loginLoad(View view) {
        Intent ScreenChange = new Intent(this, LoginActivity.class);
        startActivity(ScreenChange);
    }

    public void registerLoad(View view) {
        Intent ScreenChange = new Intent(this, RegisterActivity.class);
        startActivity(ScreenChange);
    }
}
