package com.example.moviematch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moviematch.R;
import com.example.moviematch.apiConnection.TMDBconnection;
import com.example.moviematch.models.Movie;
import com.example.moviematch.models.UserSingleton;

import java.util.concurrent.ExecutionException;

public class IntroActivity extends AppCompatActivity {
    UserSingleton user;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity);
        user = UserSingleton.getInstance();

        try {
            user.setRandomList(new TMDBconnection().execute().get());

            for(Movie movie : user.getRandomList()) {
                movie.setImg_bitmap();
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
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
