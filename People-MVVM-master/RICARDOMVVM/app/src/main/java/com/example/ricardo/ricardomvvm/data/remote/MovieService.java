package com.example.ricardo.ricardomvvm.data.remote;



import com.example.ricardo.ricardomvvm.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import io.reactivex.Observable;

public interface MovieService {
    @GET("movie/popular")
    Observable<MoviesResponse> GetPopularMovies(@Query("api_key") String apiKey,
                                          @Query("language") String language,
                                          @Query("page") int page);

   /** @GET("movie/{movie_id}")
    Call<MovieDetail> GetDetailsFromMovie(@Path("movie_id") int movie_id,
                                          @Query("api_key") String apiKey,
                                          @Query("language") String language);**/

    @GET("movie/top_rated")
    Call<MoviesResponse> GetTopRatedMovies(@Query("api_key") String apiKey,
                                           @Query("language") String language,
                                           @Query("page") int page);

   /** @GET("movie/{movie_id}/videos")
    Call<MovieTrailersResponse> GetTrailersFromMovie(@Path("movie_id") int movie_id,
                                                     @Query("api_key") String apiKey,
                                                     @Query("language") String language);**/


   /** @GET("movie/{movie_id}/reviews")
    Call<MovieReviewsResponse> GetReviewsFromMovie(@Path("movie_id") int movie_id,
                                                   @Query("api_key") String apiKey,
                                                   @Query("language") String language);**/


}
