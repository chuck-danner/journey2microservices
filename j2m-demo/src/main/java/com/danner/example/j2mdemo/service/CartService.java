package com.danner.example.j2mdemo.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.danner.example.j2mdemo.model.Cart;
import com.danner.example.j2mdemo.model.Product;

@Service
public class CartService {
     
    private HashMap<Integer, Cart> carts = new HashMap(){
        {
            put(new Integer(1), new Cart(1, 1, new ArrayList<>()));
        }
    };

    public Cart getCart(int id){
        return carts.get(id);
    }

    public Cart addToCart(int cartId, Product product){
        Cart cart = getCart(cartId);
        cart.getProducts().add(product);

        return cart;

    }

    public Cart removeFromCart(int cartId, int index){
        Cart cart = getCart(cartId);
        cart.getProducts().remove(index);

        return cart;

    }


}
