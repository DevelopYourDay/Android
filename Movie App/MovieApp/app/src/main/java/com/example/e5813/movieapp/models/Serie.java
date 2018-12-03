package com.example.e5813.movieapp.models;

import java.util.Objects;

public class Serie {

    private int id;
    private String name;
    private String SecoundName;
    private String urlImage;


    public Serie(int id, String name, String secoundName, String urlImage) {
        this.id = id;
        this.name = name;
        SecoundName = secoundName;
        this.urlImage = urlImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecoundName() {
        return SecoundName;
    }

    public void setSecoundName(String secoundName) {
        SecoundName = secoundName;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", SecoundName='" + SecoundName + '\'' +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }


}

