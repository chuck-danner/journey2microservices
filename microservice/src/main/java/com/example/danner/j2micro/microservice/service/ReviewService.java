package com.example.danner.j2micro.microservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.danner.j2micro.microservice.model.Review;
import com.example.danner.j2micro.microservice.repository.ReviewRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    private ArrayList<Review> reviews = new ArrayList<>() {
        {
            add(new Review(1, 1, 5, "Great blue Pen!"));
            add(new Review(2, 1, 4, "Pretty good pen."));
            add(new Review(3, 2, 5, "Great silver Pen!"));
            add(new Review(4, 2, 1, "The worst pen ever."));
        }
    };

    @PostConstruct
    public void init(){
        for (Review review : reviews) {
            saveReview(review);
        }
    }

    public Iterable<Review> getReviews() {
        return reviewRepository.findAll();
    }

     public Review getReview(int reviewId) {
        Optional<Review> review = reviewRepository.findById(reviewId);
        if(review.isPresent()){
            return review.get();
        }
        return null;
    }

     public List<Review> getReviewsByProductId(int productId) {
        return reviewRepository.findByProductId(productId);
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review deleteReview(int id) {
        Optional<Review> review = reviewRepository.findById(id);
        if (review.isPresent()) {
            reviewRepository.deleteById(id);
            return review.get();
        }
        return null;
    }
}
