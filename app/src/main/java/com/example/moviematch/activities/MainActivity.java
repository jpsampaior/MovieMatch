package com.example.moviematch.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.moviematch.MoviePosterAdapter;
import com.example.moviematch.R;
import com.example.moviematch.apiConnection.TMDBconnection;
import com.example.moviematch.models.Movie;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    List<Movie> lista;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);

        viewPager2 = findViewById(R.id.viewPager);

        try {
            lista = new TMDBconnection().execute().get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (Movie movie : lista) {
            Log.d("filmes2",movie.getPosterPath());
        }

        viewPagerCfg();

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.btnHome);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.btnHome:
                        return true;
                    case R.id.btnMovieList:
                        startActivity(new Intent(getApplicationContext(),IntroActivity.class));
                        return true;
                }
                return false;
            }
        });
    }

    public void viewPagerCfg() {
        viewPager2.setAdapter(new MoviePosterAdapter(lista,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(.85f + r * .15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);
    }
}