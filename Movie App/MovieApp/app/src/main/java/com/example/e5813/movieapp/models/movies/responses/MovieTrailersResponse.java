package com.example.e5813.movieapp.models.movies.responses;

import com.example.e5813.movieapp.models.movies.MovieTrailler;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieTrailersResponse {


        @SerializedName("id")
        @Expose
        private int id;

        @SerializedName("results")
        @Expose
        private List<MovieTrailler> listvideosFromMovie;

        public MovieTrailersResponse(int id, List<MovieTrailler> listMovies) {
            this.id = id;
            this.listvideosFromMovie = listMovies;
        }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MovieTrailler> getListvideosFromMovie() {
        return listvideosFromMovie;
    }

    public void setListvideosFromMovie(List<MovieTrailler> listvideosFromMovie) {
        this.listvideosFromMovie = listvideosFromMovie;
    }
}
