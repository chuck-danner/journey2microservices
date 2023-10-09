package com.example.danner.j2micro.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.danner.j2micro.microservice.model.Review;
import com.example.danner.j2micro.microservice.service.ReviewService;

@RestController
public class ReviewMicroController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public Iterable<Review> getReviews() {
        return reviewService.getReviews();
    }

    @GetMapping("/reviews/{reviewId}")
    public List<Review> getReview(@PathVariable int productId) {
        return reviewService.getReviewsByProductId(productId);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public Review deleteReviews(@PathVariable int reviewId) {
        return reviewService.deleteReview(reviewId);
    }

    @PostMapping("/reviews")
    public Review saveReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

     @PutMapping("/reviews/{reviewId}")
    public Review saveReview(@PathVariable int reviewId, @RequestBody Review review) {
        review.setId(reviewId);
        return reviewService.saveReview(review);
    }

     @GetMapping("/reviews/byproduct/{productId}")
    public List<Review> getReviews(@PathVariable int productId) {
        return reviewService.getReviewsByProductId(productId);
    }

}
