package com.example.ricardo.ricardomvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {


    @SerializedName("id")
    private int id;

    @SerializedName("poster_path")
    private String urlImage;

    public Movie(int id, String urlImage) {
        this.id = id;
        this.urlImage = urlImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }


    /**
     * nested class movie
     */
    public class MovieResponse {

        @SerializedName("page")
        public int page;

        @SerializedName("total_results")
        public int totalResults;

        @SerializedName("results")
        private List<Movie> movies;

        @SerializedName("total_pages")
        public int totalPages;

        public List<Movie> getMovies() {
            return this.movies;
        }


    }

}
