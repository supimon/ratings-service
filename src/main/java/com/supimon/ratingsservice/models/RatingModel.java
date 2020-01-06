package com.supimon.ratingsservice.models;

public class RatingModel {

    private Double rating;
    private String userId;

    public RatingModel() {
    }

    public RatingModel(double rating, String userId) {
        this.rating = rating;
        this.userId = userId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
