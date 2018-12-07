package com.example.e5813.movieapp.models.Responses;

import com.example.e5813.movieapp.models.MovieReviews;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieReviewsResponse {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("page")
    @Expose
    private int page;

    @SerializedName("results")
    @Expose
    private List<MovieReviews> listMoviesReviews;

    public MovieReviewsResponse(int id, int page, List<MovieReviews> listMoviesReviews) {
        this.id = id;
        this.page = page;
        this.listMoviesReviews = listMoviesReviews;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieReviews> getListMoviesReviews() {
        return listMoviesReviews;
    }

    public void setListMoviesReviews(List<MovieReviews> listMoviesReviews) {
        this.listMoviesReviews = listMoviesReviews;
    }
}
