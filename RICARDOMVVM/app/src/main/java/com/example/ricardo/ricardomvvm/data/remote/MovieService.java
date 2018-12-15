package com.example.ricardo.ricardomvvm.data.remote;



import com.example.ricardo.ricardomvvm.model.Movie;
import com.example.ricardo.ricardomvvm.model.MovieDetail;
import com.example.ricardo.ricardomvvm.model.MovieReview;
import com.example.ricardo.ricardomvvm.model.MovieTrailler;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import io.reactivex.Observable;

public interface MovieService {
    @GET("movie/popular")
    Observable<Movie.MovieResponse> GetPopularMovies(@Query("api_key") String apiKey,
                                                     @Query("language") String language,
                                                     @Query("page") int page);

    @GET("movie/{movie_id}")
    Observable<MovieDetail> GetDetailsFromMovie(@Path("movie_id") int movie_id,
                                                @Query("api_key") String apiKey,
                                                @Query("language") String language);

    @GET("movie/top_rated")
    Observable<Movie.MovieResponse> GetTopRatedMovies(@Query("api_key") String apiKey,
                                                      @Query("language") String language,
                                                      @Query("page") int page);

   @GET("movie/{movie_id}/videos")
   Observable<MovieTrailler.MovieTrailersResponse> GetTrailersFromMovie(@Path("movie_id") int movie_id,
                                                  @Query("api_key") String apiKey,
                                                  @Query("language") String language);


   @GET("movie/{movie_id}/reviews")
   Observable<MovieReview.MovieReviewsResponse> GetReviewsFromMovie(@Path("movie_id") int movie_id,
                                               @Query("api_key") String apiKey,
                                               @Query("language") String language);


}
