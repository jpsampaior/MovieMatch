package com.example.moviematch;

import android.os.AsyncTask;

import com.example.moviematch.models.Movie;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JsonConnection extends AsyncTask<Void, Void, String> {

    @Override
    protected String doInBackground(Void... voids) {
        StringBuilder resposta = new StringBuilder();

        try{
            URL url = new URL("https://api.themoviedb.org/3/movie/popular?api_key=2f3597a16a6d886246818433956047aa");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoInput(true);
            connection.setConnectTimeout(5000);

            connection.connect();

            Scanner scanner = new Scanner(url.openStream());
            while(scanner.hasNext()){
                resposta.append(scanner.next());
            }

        }
        catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return String.valueOf(resposta);
    }
}
