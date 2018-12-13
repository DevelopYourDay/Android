package com.example.ricardo.ricardomvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class MovieTrailler {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("key")
    @Expose
    private String key;

    @SerializedName("site")
    @Expose
    private String Site;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("size")
    @Expose
    private int sizeQuality;

    public MovieTrailler(String id, String name, String key, String site, String type, int sizeQuality) {
        this.id = id;
        this.name = name;
        this.key = key;
        Site = site;
        this.type = type;
        this.sizeQuality = sizeQuality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSite() {
        return Site;
    }

    public void setSite(String site) {
        Site = site;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSizeQuality() {
        return sizeQuality;
    }

    public void setSizeQuality(int sizeQuality) {
        this.sizeQuality = sizeQuality;
    }


    /**
     * nested class movie  Trailers Response
     */
    public class MovieTrailersResponse {


        @SerializedName("id")
        private int id;

        @SerializedName("results")
        private List<MovieTrailler> listvideosFromMovie;

        public MovieTrailersResponse(int id, List<MovieTrailler> listMovies) {
            this.id = id;
            this.listvideosFromMovie = listMovies;
        }


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<MovieTrailler> getListvideosFromMovie() {
            return listvideosFromMovie;
        }

        public void setListvideosFromMovie(List<MovieTrailler> listvideosFromMovie) {
            this.listvideosFromMovie = listvideosFromMovie;
        }
    }
}
