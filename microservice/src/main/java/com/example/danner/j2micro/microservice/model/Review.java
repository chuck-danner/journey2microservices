package com.example.danner.j2micro.microservice.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Review {
   @jakarta.persistence.Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int productId;
    private int score;
    private String review;
    
    public Review(int id, int productId, int score, String review) {
        this.id = id;
        this.productId = productId;
        this.score = score;
        this.review = review;
    }
    

    public Review() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}