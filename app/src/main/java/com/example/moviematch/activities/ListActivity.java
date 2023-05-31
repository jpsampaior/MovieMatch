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
import com.example.moviematch.models.Movie;
import com.example.moviematch.models.UserSingleton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    ViewPager2 vpWatchList;
    ViewPager2 vpWatchedList;
    ViewPager2 vpAvoidList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        vpWatchList = findViewById(R.id.vpWatchList);
        vpWatchedList = findViewById(R.id.vpWatchedList);
        vpAvoidList = findViewById(R.id.vpAvoidList);

        UserSingleton user = UserSingleton.getInstance();
        viewPagerCfg(vpWatchList,user.getWatchList());
        viewPagerCfg(vpWatchedList,user.getWatchedMovies());
        viewPagerCfg(vpAvoidList,user.getAvoidList());

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
