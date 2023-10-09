package com.example.danner.j2micro.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.danner.j2micro.microservice.model.Review;
import com.example.danner.j2micro.microservice.service.ReviewService;

@RestController
public class ReviewMicroController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews/{productId}")
    public List<Review> getReviews(@PathVariable int productId) {
        return reviewService.getReviews(productId);
    }

    @DeleteMapping("/review/{reviewId}")
    public Review deleteReviews(@PathVariable int reviewId) {
        return reviewService.deleteReview(reviewId);
    }

    @PostMapping("/reviews/{productId}")
    public Review saveReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

}
