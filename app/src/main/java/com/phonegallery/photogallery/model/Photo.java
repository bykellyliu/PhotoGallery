package com.phonegallery.photogallery.model;

/**
 * Created by kellyliu on 2017-05-27.
 */

public class Photo {
    private String name;
    private int img;
    float rating;

    public Photo(String name, int img, float rating) {
        this.name = name;
        this.img = img;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

}

