package com.danner.example.j2mdemo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.danner.example.j2mdemo.model.Product;
import com.danner.example.j2mdemo.service.CustomerService;
import com.danner.example.j2mdemo.service.ProductsService;

@Controller
public class WelcomeController {

    @Value("${welcome.message}")
    private String message;

     private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

     @Autowired
     ProductsService productsService;

     @Autowired
     CustomerService customerService;

     @GetMapping("/")
     public String main(Model model){
       Product[] products = productsService.getProducts();
      
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);
        model.addAttribute("products", products);
        model.addAttribute("customer", customerService.getCustomer(1));

        return "welcome";
     }

     @GetMapping("/hello") 
     public String mainWithParam(@RequestParam(name = "name", required = false, defaultValue = "") 
     String name, Model model ){

        model.addAttribute("message", name);

        return "welcome";
     }
    
}
