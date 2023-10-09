package com.danner.example.j2mdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    
    private String name;

    private String description; 

    private String price; 
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; 
   

    public Product(String name, String description, String price, int id) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.id = id;
    }
    

    public Product() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    
}
