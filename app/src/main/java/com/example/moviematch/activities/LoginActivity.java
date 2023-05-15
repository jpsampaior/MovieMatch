package com.example.moviematch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moviematch.R;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    public void loginClick(View view) {
        Intent ScreenChange = new Intent(this, MainActivity.class);
        startActivity(ScreenChange);
    }
}
