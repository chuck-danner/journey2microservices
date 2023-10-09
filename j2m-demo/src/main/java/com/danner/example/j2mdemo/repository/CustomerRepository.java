package com.danner.example.j2mdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.danner.example.j2mdemo.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    
}
