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
import android.widget.TextView;

import com.example.moviematch.FadeEffect;
import com.example.moviematch.MoviePosterAdapter;
import com.example.moviematch.R;
import com.example.moviematch.models.Movie;
import com.example.moviematch.models.UserSingleton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager2;
    UserSingleton user;

    TextView tvBtnClickConfirmation;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        user = UserSingleton.getInstance();
        Collections.shuffle(user.getRandomList());

        tvBtnClickConfirmation = findViewById(R.id.tvBtnClickConfirmation);
        viewPager2 = findViewById(R.id.viewPager);

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
                        startActivity(new Intent(getApplicationContext(),ListActivity.class));
                        return true;
                }
                return false;
            }
        });
    }

    public void viewPagerCfg() {
        viewPager2.setAdapter(new MoviePosterAdapter(user.getRandomList(),viewPager2));
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

        viewPager2.bringChildToFront(viewPager2.getChildAt(1));
        viewPager2.setPageTransformer(compositePageTransformer);
    }
    
    public void onPreferenceClick(View view) {
        Movie currentMovie = user.getRandomList().get(viewPager2.getCurrentItem());

        switch (view.getId()) {
            case R.id.btnHeart:
                user.addToWatchList(currentMovie);
                tvBtnClickConfirmation.setText(R.string.watchlist_message);
                tvBtnClickConfirmation.setTextColor(getResources().getColor(R.color.red));
                break;
            case R.id.btnCheck:
                user.addWatchedMovie(currentMovie);
                tvBtnClickConfirmation.setText(R.string.watchedlist_message);
                tvBtnClickConfirmation.setTextColor(getResources().getColor(R.color.limeGreen));
                break;
            case R.id.btnX:
                user.addToAvoidList(currentMovie);
                tvBtnClickConfirmation.setText(R.string.avoidlist_message);
                tvBtnClickConfirmation.setTextColor(getResources().getColor(R.color.movieWhite));
                break;
        }

        confirmationEffect();
        Log.d("abcdef",Integer.toString(currentMovie.getRuntime()));

        if (viewPager2.getCurrentItem() != user.getRandomList().size()) {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    }

    public void confirmationEffect() {
        FadeEffect.fadeIn(tvBtnClickConfirmation, 1000);
        FadeEffect.fadeOut(tvBtnClickConfirmation, 1000);
    }

    public void onProfileClick(View view) {
        Intent ScreenChange = new Intent(this, ProfileActivity.class);
        startActivity(ScreenChange);
    }
}