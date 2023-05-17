package com.example.moviematch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moviematch.JsonConnection;
import com.example.moviematch.R;
import com.example.moviematch.TheMovieDBAPI;
import com.example.moviematch.models.Movie;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class IntroActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity);

        List<Movie> lista = null;

        TheMovieDBAPI api = new TheMovieDBAPI();
        try {
            lista = api.getPopularMovies();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(this,lista.get(0).getTitle(),Toast.LENGTH_LONG);
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