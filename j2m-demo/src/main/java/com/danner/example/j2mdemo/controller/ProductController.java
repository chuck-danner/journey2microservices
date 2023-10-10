package com.danner.example.j2mdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.danner.example.j2mdemo.model.Product;
import com.danner.example.j2mdemo.service.CustomerService;
import com.danner.example.j2mdemo.service.ProductsService;

@Controller
public class ProductController {

   @Autowired
   ProductsService productsService;

   @Autowired
   CustomerService customerService;

   @GetMapping("/")
   public String main(Model model) {
      Iterable<Product> products = productsService.getProducts();

      model.addAttribute("products", products);
      model.addAttribute("customer", customerService.getCustomer(1));

      return "products";
   }

}
