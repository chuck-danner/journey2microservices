package com.danner.example.j2mdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.danner.example.j2mdemo.model.Review;

@Service
public class ReviewService {

    @Value("${micro.review.url}")
    private String reviewsURL;

    public List<Review> getReviews(int productId) {
        RestTemplate template = new RestTemplate();
        String targetUrl = reviewsURL + productId;
        Review[] reviews = template.getForObject(targetUrl, Review[].class);

        return java.util.Arrays.asList(reviews);

    }

}
