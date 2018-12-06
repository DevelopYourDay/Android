package com.example.e5813.movieapp.models.Responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieVideosResponse {


        @SerializedName("id")
        @Expose
        private int id;

        @SerializedName("results")
        @Expose
        private List<MovieVideosResponse> listvideosFromMovie;

        public MovieVideosResponse(int id, List<MovieVideosResponse> listMovies) {
            this.id = id;
            this.listvideosFromMovie = listMovies;
        }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MovieVideosResponse> getListvideosFromMovie() {
        return listvideosFromMovie;
    }

    public void setListvideosFromMovie(List<MovieVideosResponse> listvideosFromMovie) {
        this.listvideosFromMovie = listvideosFromMovie;
    }
}
