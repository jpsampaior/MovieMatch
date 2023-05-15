package com.example.moviematch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moviematch.R;

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
