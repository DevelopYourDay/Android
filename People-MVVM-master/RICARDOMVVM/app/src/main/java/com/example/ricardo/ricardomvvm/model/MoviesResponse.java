package com.example.ricardo.ricardomvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResponse {

    @SerializedName("page")
    @Expose
    public int page;

    @SerializedName("total_results")
    @Expose
    public int totalResults;

    @SerializedName("results")
    @Expose
    private List<Movie> movies;

    @SerializedName("total_pages")
    @Expose
    public int totalPages;

    public List<Movie> getMovies() {
        return this.movies;
    }


}
