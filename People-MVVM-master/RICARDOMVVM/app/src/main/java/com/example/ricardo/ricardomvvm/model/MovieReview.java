package com.example.ricardo.ricardomvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieReview {


    @SerializedName("author")
    private String author;

    @SerializedName("content")
    private String content;

    @SerializedName("id")
    private String id;

    @SerializedName("url")
    private String url;

    public MovieReview(String author, String content, String id, String url) {
        this.author = author;
        this.content = content;
        this.id = id;
        this.url = url;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }




    public class MovieReviewsResponse {
        @SerializedName("id")
        private int id;

        @SerializedName("page")
        private int page;

        @SerializedName("results")
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

}
