package com.danner.example.j2mdemo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danner.example.j2mdemo.model.Cart;
import com.danner.example.j2mdemo.model.Product;
import com.danner.example.j2mdemo.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart getCart(int customerId) {
        java.util.List<Cart> cart = cartRepository.findByCustomerId(customerId);
        if (cart.size() > 0) {
            return cart.get(0);
        }
        return new Cart(customerId, customerId, new ArrayList<>());
    }

    public Cart addToCart(int cartId, Product product) {
        Cart cart = getCart(cartId);
        if (!cart.getProducts().contains(product)) {
            cart.getProducts().add(product);
        }

        return cartRepository.save(cart);

    }

    public Cart removeFromCart(int cartId, int index) {
        Cart cart = getCart(cartId);
        cart.getProducts().remove(index);
        return cartRepository.save(cart);
    }

}
