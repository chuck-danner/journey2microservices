package com.danner.example.j2mdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.danner.example.j2mdemo.model.Customer;
import com.danner.example.j2mdemo.service.CustomerService;

@Controller
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping("/customer/{customerId}")
  public String mainWithParam(@PathVariable int customerId, Model model) {

    Customer customer = customerService.getCustomer(customerId);

    model.addAttribute("customer", customer);

    return "customer";
  }

}
