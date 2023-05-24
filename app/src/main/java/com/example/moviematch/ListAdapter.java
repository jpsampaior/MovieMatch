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

import com.example.moviematch.models.Movie;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Movie> {

    public ListAdapter(Context context, ArrayList<Movie> moviesDetailsArrayList){
        super(context,R.layout.list_item, moviesDetailsArrayList);

    }

    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Movie movieDetails = getItem(position);
        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.sampleJoker);
        //imageView.setImageResource(movieDetails.image_id);
        return super.getView(position,convertView, parent);
    }

}
