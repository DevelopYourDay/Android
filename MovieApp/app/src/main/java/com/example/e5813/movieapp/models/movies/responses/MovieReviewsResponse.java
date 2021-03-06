package com.example.e5813.movieapp.models.movies.responses;

import com.example.e5813.movieapp.models.movies.MovieReview;
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
    private List<MovieReview> listMoviesReviews;

    public MovieReviewsResponse(int id, int page, List<MovieReview> listMoviesReviews) {
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

    public List<MovieReview> getListMoviesReviews() {
        return listMoviesReviews;
    }

    public void setListMoviesReviews(List<MovieReview> listMoviesReviews) {
        this.listMoviesReviews = listMoviesReviews;
    }
}
