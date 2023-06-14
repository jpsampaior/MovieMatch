package com.example.moviematch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.moviematch.R;
import com.example.moviematch.models.Movie;
import com.example.moviematch.models.User;
import com.example.moviematch.models.UserSingleton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {
    UserSingleton user;
    int watchedMinutes;

    TextView tvWatchedMinutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.btnHome);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.btnHome:
                        return true;
                    case R.id.btnMovieList:
                        startActivity(new Intent(getApplicationContext(),ListActivity.class));
                        return true;

                }
                return false;
            }
        });

        user = UserSingleton.getInstance();


        tvWatchedMinutes = findViewById(R.id.tvWatchedMinutes);
        watchedMinutes = 0;

        for(Movie movie : user.getWatchedMovies()) {
            watchedMinutes+=movie.getRuntime();
        }

        tvWatchedMinutes.setText(Integer.toString(watchedMinutes));
    }
}