package com.example.ricardo.ricardomvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResponse {

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
