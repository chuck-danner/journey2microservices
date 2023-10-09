package com.danner.example.j2mdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.danner.example.j2mdemo.model.Customer;
import com.danner.example.j2mdemo.model.Product;
import com.danner.example.j2mdemo.model.Review;
import com.danner.example.j2mdemo.service.CustomerService;
import com.danner.example.j2mdemo.service.ProductsService;
import com.danner.example.j2mdemo.service.ReviewService;

@Controller
public class ReviewController {

  @Autowired
  private ReviewService reviewService;

  @Autowired
  private ProductsService productsService;

  @Autowired
  CustomerService customerService;

  @GetMapping("/review")
  public String mainWithParam(@RequestParam(name = "productId", required = false, defaultValue = "0") int productId,
      Model model) {

    List<Review> reviews = reviewService.getReviews(productId);
    Product product = productsService.getProduct(productId);
    Customer customer = customerService.getCustomer(1);

    model.addAttribute("reviews", reviews);
    model.addAttribute("product", product);
    model.addAttribute("customer", customer);

    return "reviews";
  }

}
