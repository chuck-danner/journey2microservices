package com.example.danner.j2micro.microservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.danner.j2micro.microservice.model.Review;
import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {
    List<Review> findByProductId(int productId);
}
