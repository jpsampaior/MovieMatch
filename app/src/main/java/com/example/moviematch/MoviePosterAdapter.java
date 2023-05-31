package com.example.moviematch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.moviematch.apiConnection.imageBitmapTask;
import com.example.moviematch.models.Movie;

import java.util.List;

public class MoviePosterAdapter extends RecyclerView.Adapter<MoviePosterAdapter.MoviePosterAdapterHolder> {
    private List<Movie> moviesList;
    private ViewPager2 viewPager2;

    public MoviePosterAdapter(List<Movie> moviesList, ViewPager2 viewPager2) {
        this.moviesList = moviesList;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public MoviePosterAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MoviePosterAdapterHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_location,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MoviePosterAdapterHolder holder, int position) {
        holder.setImage(moviesList.get(position));
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    static class MoviePosterAdapterHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        MoviePosterAdapterHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.poster);
        }

        void setImage(Movie movie) {
            new imageBitmapTask(imageView).execute(movie.getPosterPath());
        }
    }
}
