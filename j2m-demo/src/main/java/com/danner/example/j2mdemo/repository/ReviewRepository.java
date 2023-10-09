package com.danner.example.j2mdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.danner.example.j2mdemo.model.Review;
import java.util.List;


public interface ReviewRepository extends CrudRepository<Review, Integer>{
    List<Review> getByProductId(int productId);    
}
