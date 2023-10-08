package com.danner.example.j2mdemo.service;

import org.springframework.stereotype.Service;

import com.danner.example.j2mdemo.model.Product;

@Service
public class ProductsService {

    private Product[] products = new Product[] {
            new Product("Blue Pen", "Blue Fountain Pen", "$15.99", 1),
            new Product("Silver Pen", "Silver Fountain Pen", "$20.99", 2),
            new Product("Green Pen", "Green Fountain Pen", "$23.99", 3),
            new Product("Orange Pen", "Orange Fountain Pen", "$12.99", 4),
            new Product("Purple Pen", "Purple Fountain Pen", "$22.99", 5)
    };

    public Product[] getProducts() {
        return products;
    }

    public Product getProduct(int id) {
        return products[id - 1];
    }

}