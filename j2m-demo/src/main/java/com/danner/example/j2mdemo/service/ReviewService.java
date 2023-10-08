package com.danner.example.j2mdemo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.danner.example.j2mdemo.model.Review;

@Service
public class ReviewService {
    private ArrayList<Review> reviews = new ArrayList<>() {
        {
            add(new Review(1, 1, 5, "Great Pen!"));
            add(new Review(1, 1, 4, "Pretty good pen."));
        }
    };

    public ArrayList<Review> getReviews(int productId){
        return reviews;
    }

}
