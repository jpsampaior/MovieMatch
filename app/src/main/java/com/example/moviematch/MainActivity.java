package com.example.moviematch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        viewPager2 = findViewById(R.id.viewPager);

        List<PosterItem> posterItems = new ArrayList<>();

        posterItems.add(new PosterItem(R.drawable.sample1));
        posterItems.add(new PosterItem(R.drawable.sample2));
        posterItems.add(new PosterItem(R.drawable.sample3));
        posterItems.add(new PosterItem(R.drawable.sample4));

        viewPager2.setAdapter(new MoviePosterAdapter(posterItems,viewPager2));
    }
}