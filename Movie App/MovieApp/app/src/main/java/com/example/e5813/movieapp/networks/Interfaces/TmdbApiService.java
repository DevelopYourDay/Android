package com.example.e5813.movieapp.networks.Interfaces;

import com.example.e5813.movieapp.models.MovieDetails;
import com.example.e5813.movieapp.models.Responses.MovieReviewsResponse;
import com.example.e5813.movieapp.models.Responses.MovieVideosResponse;
import com.example.e5813.movieapp.models.Responses.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TmdbApiService {
    @GET("movie/popular")
    Call<MoviesResponse> listPopularMovies(@Query("api_key") String apiKey,
                                           @Query ("language") String language,
                                            @Query("page") int page);

    @GET("movie/{movie_id}")
    Call<MovieDetails> movieDetails(@Path("movie_id") int movie_id,
                                    @Query("api_key") String apiKey,
                                    @Query ("language") String language);

    @GET("movie/top_rated")
    Call<MoviesResponse> listTopRated(@Query("api_key") String apiKey,
                                           @Query ("language") String language,
                                             @Query("page") int page);

    @GET("movie/{movie_id}/videos")
    Call<MovieVideosResponse> listVideosFromMovie(@Path("movie_id") int movie_id,
                                                  @Query("api_key") String apiKey,
                                                  @Query ("language") String language);


    @GET("movie/{movie_id}/reviews")
    Call<MovieReviewsResponse> listMoviesReviews(@Path("movie_id") int movie_id,
                                                 @Query("api_key") String apiKey,
                                                 @Query ("language") String language);


}
