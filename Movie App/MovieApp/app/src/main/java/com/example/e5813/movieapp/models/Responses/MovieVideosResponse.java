package com.example.e5813.movieapp.models.Responses;

import com.example.e5813.movieapp.models.MovieVideos;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieVideosResponse {


        @SerializedName("id")
        @Expose
        private int id;

        @SerializedName("results")
        @Expose
        private List<MovieVideos> listvideosFromMovie;

        public MovieVideosResponse(int id, List<MovieVideos> listMovies) {
            this.id = id;
            this.listvideosFromMovie = listMovies;
        }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MovieVideos> getListvideosFromMovie() {
        return listvideosFromMovie;
    }

    public void setListvideosFromMovie(List<MovieVideos> listvideosFromMovie) {
        this.listvideosFromMovie = listvideosFromMovie;
    }
}
