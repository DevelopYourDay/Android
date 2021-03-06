package com.example.e5813.movieapp.models.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieDetail {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("release_date")
    @Expose
    private String year;

    @SerializedName("runtime")
    @Expose
    private String duration;

    @SerializedName("vote_average")
    @Expose
    private String rating;

    @SerializedName("overview")
    @Expose
    private String description;

    @SerializedName("poster_path")
    @Expose
    private String utlImage;


    public MovieDetail(int id, String title, String year, String duration, String rating, String description, String utlImage) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.rating = rating;
        this.description = description;
        this.utlImage = utlImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUtlImage() {
        return utlImage;
    }

    public void setUtlImage(String utlImage) {
        this.utlImage = utlImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
