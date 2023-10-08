package com.danner.example.j2mdemo.model;

import java.util.ArrayList;

public class Cart {
    
    private int cartId;
    private int customerId;
    private ArrayList<Product> products;
    public Cart(int cartId, int customerId, ArrayList<Product> products) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.products = products;
    }
    public int getCartId() {
        return cartId;
    }
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public ArrayList<Product> getProducts() {
        return products;
    }
    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

}
