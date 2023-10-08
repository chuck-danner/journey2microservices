package com.danner.example.j2mdemo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.danner.example.j2mdemo.model.Customer;

@Service
public class CustomerService {

    private ArrayList<Customer> customers = new ArrayList<>() {
        {
            add(new Customer(1, "Chuck", "Danner", "123 here Street"));
        }
    };

public Customer getCustomer( int id){
    return customers.get(id-1);
}

}