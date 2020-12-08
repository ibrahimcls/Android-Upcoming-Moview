package com.android.javajsonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import com.android.javajsonapp.adapters.MovieListView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private MovieListView listViewAdapter;
    private ArrayList<Result> movies;
    String API_KEY = "e17d721f87afad23894e90ac1c24c3d2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movies =new  ArrayList<Result>();
        listView = findViewById(R.id.movie_list_view);
        setTitle("Upcoming Movies");
        setTitleColor(R.color.Red);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        TheMovieDbApi theMovieDbApi =retrofit.create(TheMovieDbApi.class);
        Call<Movie> call = theMovieDbApi.getMovieList(API_KEY);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {

                if(!response.isSuccessful()){
                    System.out.println("fdsdf");
                    return;
                }
                Result[] list = response.body().getResults();
                for(Result movie:list){
                    movies.add(movie);
                }
                listViewAdapter =new MovieListView(MainActivity.this,movies);
                listView.setAdapter(listViewAdapter);
            }
            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                System.out.println(t.toString());
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(),MovieDetails.class);
                intent.putExtra("movie",movies.get(position));
                startActivity(intent);
            }
        });


    }

}