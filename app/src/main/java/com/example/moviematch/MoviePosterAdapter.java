package com.example.moviematch;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;

public class MoviePosterAdapter extends RecyclerView.Adapter<MoviePosterAdapter.MoviePosterAdapterHolder> {
    private List<PosterItem> posterItems;
    private ViewPager2 viewPager2;

    public MoviePosterAdapter(List<PosterItem> posterItems, ViewPager2 viewPager2) {
        this.posterItems = posterItems;
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
        holder.setImage(posterItems.get(position));
    }

    @Override
    public int getItemCount() {
        return posterItems.size();
    }

    static class MoviePosterAdapterHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        MoviePosterAdapterHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.poster);
        }

        void setImage(PosterItem posterItem) {
            imageView.setImageResource(posterItem.getImage());

        }
    }
}
