package com.danner.example.j2mdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.danner.example.j2mdemo.model.Cart;
import java.util.List;


public interface CartRepository extends CrudRepository<Cart, Integer> {
    List<Cart> findByCustomerId(int customerId);
}
