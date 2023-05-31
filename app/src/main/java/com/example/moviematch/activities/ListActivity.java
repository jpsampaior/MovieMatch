package com.example.moviematch.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.moviematch.MoviePosterAdapter;
import com.example.moviematch.R;
import com.example.moviematch.apiConnection.TMDBconnection;
import com.example.moviematch.models.Movie;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ListActivity extends AppCompatActivity {
    ViewPager2 vpWatchList;
    ViewPager2 vpWatchedList;
    ViewPager2 vpAvoidList;
    List<Movie> lista1;
    List<Movie> lista2;
    List<Movie> lista3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        vpWatchList = findViewById(R.id.vpWatchList);
        vpWatchedList = findViewById(R.id.vpWatchedList);
        vpAvoidList = findViewById(R.id.vpAvoidList);

        try {
            lista1 = new TMDBconnection().execute().get();
            Collections.shuffle(lista1);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        viewPagerCfg(vpWatchList,lista1);
        viewPagerCfg(vpWatchedList,lista1);
        viewPagerCfg(vpAvoidList,lista1);

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.btnMovieList);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.btnHome:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        return true;
                    case R.id.btnMovieList:
                        return true;
                }
                return false;
            }
        });
    }

    public void viewPagerCfg(ViewPager2 vp, List<Movie> lista) {
        vp.setAdapter(new MoviePosterAdapter(lista,vp));
        vp.setClipToPadding(false);
        vp.setClipChildren(false);
        vp.setOffscreenPageLimit(5);
        vp.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(1));

        vp.bringChildToFront(vp.getChildAt(1));
        vp.setPageTransformer(compositePageTransformer);
    }
}
