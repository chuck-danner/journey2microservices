package com.danner.example.j2mdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.danner.example.j2mdemo.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    
}
