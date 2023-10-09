package com.danner.example.j2mdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danner.example.j2mdemo.model.Product;
import com.danner.example.j2mdemo.repository.ProductRepository;

import jakarta.annotation.PostConstruct;

@Service
public class ProductsService {

    private Product[] products = new Product[] {
            new Product("Blue Pen", "Blue Fountain Pen", "$15.99", 1),
            new Product("Silver Pen", "Silver Fountain Pen", "$20.99", 2),
            new Product("Green Pen", "Green Fountain Pen", "$23.99", 3),
            new Product("Orange Pen", "Orange Fountain Pen", "$12.99", 4),
            new Product("Purple Pen", "Purple Fountain Pen", "$22.99", 5)
    };

    @PostConstruct
    public void init(){
        for (Product product : products) {
            saveProduct(product);
        }
    }
    
    @Autowired
    private ProductRepository productRepository;

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(int id) {
        Optional<Product> product =  productRepository.findById(id);
        if(product.isPresent()){
            return product.get();
        }
        return null;
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

}