package com.android.javajsonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetails extends AppCompatActivity {
    TextView  overview,popularity,movieVoteCount,movieVoteAverage;
    ImageView adultIcon,movieImage;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        Bundle bundle = getIntent().getExtras();
        Result movie = bundle.getParcelable("movie");
        setTitle(movie.getTitle());

        movieImage = findViewById(R.id.movie_image);
        movieVoteCount=findViewById(R.id.movie_vote_count);
        movieVoteAverage=findViewById(R.id.movie_vote_average);

        overview = findViewById(R.id.movie_overview);
        popularity = findViewById(R.id.movie_popularity);
        adultIcon = findViewById(R.id.adult_icon);




        overview.setText(movie.getOverview());
        popularity.setText("Popularity : "+movie.getPopularity());
        movieVoteCount.setText("Vote Count : " + movie.getVoteCount());
        movieVoteAverage.setText("Vote Average : "+Double.toString(movie.getVoteAverage()));
        String url = "https://image.tmdb.org/t/p/w500"+movie.getBackdropPath();
        Picasso.get().load(url).into(movieImage);

         if(movie.getAdult()){
             adultIcon.setImageResource(R.drawable.ic_baseline_done_24);
                //adultIcon.setImageResource(getResources().getIdentifier("checkbox_on_background","drawable",getPackageName()));
         }else {
             adultIcon.setImageResource(R.drawable.ic_baseline_cancel_24);
             //adultIcon.setImageResource(getResources().getIdentifier("btn_dialog","drawable",getPackageName()));
         }


    }
}