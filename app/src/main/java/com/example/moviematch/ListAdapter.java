package com.example.moviematch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<MovieDetails> {

    public ListAdapter(Context context, ArrayList<MovieDetails> moviesDetailsArrayList){
        super(context,R.layout.list_item, moviesDetailsArrayList);

    }

    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent){
        MovieDetails movieDetails = getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.sampleJoker);
        imageView.setImageResource(movieDetails.image_id);
        return super.getView(position,convertView, parent);
    }

}
