package com.android.javajsonapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TheMovieDbApi {

    @GET("3/movie/upcoming")
    Call<Movie> getMovieList(@Query("api_key") String API_KEY);

}
