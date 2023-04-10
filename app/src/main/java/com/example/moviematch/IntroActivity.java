package com.example.moviematch;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class IntroActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity);
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
