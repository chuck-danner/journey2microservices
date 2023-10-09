package com.danner.example.j2mdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danner.example.j2mdemo.model.Review;
import com.danner.example.j2mdemo.repository.ReviewRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ReviewService {
    private ArrayList<Review> reviews = new ArrayList<>() {
        {
            add(new Review(1, 1, 5, "Great blue Pen!"));
            add(new Review(2, 1, 4, "Pretty good pen."));
            add(new Review(3, 2, 5, "Great silver Pen!"));
            add(new Review(4, 2, 1, "The worst pen ever."));
        }
    };

    @PostConstruct
    public void init() {
        for (Review review : reviews) {
            saveReview(review);
        }
    }

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviews(int productId) {
        return reviewRepository.getByProductId(productId);
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

}
