package com.danner.example.j2mdemo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danner.example.j2mdemo.model.Customer;
import com.danner.example.j2mdemo.repository.CustomerRepository;

import jakarta.annotation.PostConstruct;

@Service
public class CustomerService {

    private ArrayList<Customer> customers = new ArrayList<>() {
        {
            add(new Customer(1, "Chuck", "Danner", "123 here Street"));
        }
    };

    @PostConstruct
    public void init() {
        for (Customer customer : customers) {
            saveCustomer(customer);
        }
    }

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        }
        return null;

    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

}