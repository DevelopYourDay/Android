package com.example.e5813.movieapp.networks.tmdb.interfaces;

import com.example.e5813.movieapp.models.movies.MovieDetail;
import com.example.e5813.movieapp.models.movies.responses.MovieReviewsResponse;
import com.example.e5813.movieapp.models.movies.responses.MovieTrailersResponse;
import com.example.e5813.movieapp.models.movies.responses.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TmdbApiService {
    @GET("movie/popular")
    Call<MoviesResponse> GetPopularMovies(@Query("api_key") String apiKey,
                                          @Query ("language") String language,
                                          @Query("page") int page);

    @GET("movie/{movie_id}")
    Call<MovieDetail> GetDetailsFromMovie(@Path("movie_id") int movie_id,
                                          @Query("api_key") String apiKey,
                                          @Query ("language") String language);

    @GET("movie/top_rated")
    Call<MoviesResponse> GetTopRatedMovies(@Query("api_key") String apiKey,
                                           @Query ("language") String language,
                                           @Query("page") int page);

    @GET("movie/{movie_id}/videos")
    Call<MovieTrailersResponse> GetTraillersFromMovie(@Path("movie_id") int movie_id,
                                                      @Query("api_key") String apiKey,
                                                      @Query ("language") String language);


    @GET("movie/{movie_id}/reviews")
    Call<MovieReviewsResponse> GetReviewsFromMovie(@Path("movie_id") int movie_id,
                                                   @Query("api_key") String apiKey,
                                                   @Query ("language") String language);


}
