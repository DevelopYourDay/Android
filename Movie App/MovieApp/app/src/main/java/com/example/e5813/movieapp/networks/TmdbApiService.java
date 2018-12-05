package com.example.e5813.movieapp.networks;

import com.example.e5813.movieapp.models.MovieDetails;
import com.example.e5813.movieapp.models.MoviesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TmdbApiService {
    @GET("movie/popular")
    Call<MoviesResponse> listPopularMovies(@Query("api_key") String apiKey,
                                           @Query ("language") String language);

    @GET("movie/{movie_id}")
    Call<MovieDetails> movieDetails(@Path("movie_id") int movie_id,
                                    @Query("api_key") String apiKey,
                                    @Query ("language") String language);

    @GET("movie/top_rated")
    Call<MoviesResponse> listTopRated(@Query("api_key") String apiKey,
                                           @Query ("language") String language);
}
