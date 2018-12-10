package com.example.e5813.movieapp.models.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Movie implements Serializable {


    @SerializedName("id")
    @Expose
    private int id;



    @SerializedName("poster_path")
    @Expose
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

}
