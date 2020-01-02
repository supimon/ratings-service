package com.supimon.ratingsservice.models;

public class RatingModel {

    private double rating;
    private String userId;

    public RatingModel(double rating, String userId) {
        this.rating = rating;
        this.userId = userId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
