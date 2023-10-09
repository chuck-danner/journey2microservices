package com.danner.example.j2mdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.danner.example.j2mdemo.model.Cart;
import com.danner.example.j2mdemo.model.Customer;
import com.danner.example.j2mdemo.model.Product;
import com.danner.example.j2mdemo.service.CartService;
import com.danner.example.j2mdemo.service.CustomerService;
import com.danner.example.j2mdemo.service.ProductsService;

@Controller
public class CartController {

   @Autowired
   private CartService cartService;

   @Autowired
   private ProductsService productsService;

   @Autowired
   private CustomerService customerService;

   @GetMapping("/cart/{customerId}")
   public String mainWithParam(@PathVariable int customerId, Model model) {

      Cart cart = cartService.getCart(customerId);
      Customer customer = customerService.getCustomer(customerId);
      model.addAttribute("cart", cart);
      model.addAttribute("customer", customer);

      return "cart";
   }

   @GetMapping("/cart/{customerId}/add/{productId}")
   public String addtoCart(@PathVariable int customerId, @PathVariable int productId,
         Model model) {

      Product product = productsService.getProduct(productId);
      Cart cart = cartService.addToCart(customerId, product);
      Customer customer = customerService.getCustomer(customerId);

      model.addAttribute("cart", cart);
      model.addAttribute("customer", customer);
      return "cart";
   }

   @GetMapping("/cart/{customerId}/remove/{indexId}")
   public String removeFromCart(@PathVariable int customerId, @PathVariable int indexId,
         Model model) {

      Cart cart = cartService.removeFromCart(customerId, indexId);
      Customer customer = customerService.getCustomer(customerId);

      model.addAttribute("cart", cart);
      model.addAttribute("customer", customer);
      return "cart";
   }

}
