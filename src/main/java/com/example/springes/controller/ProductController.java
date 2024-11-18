package com.example.springes.controller;

import com.example.springes.entity.Product;
import com.example.springes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/apis")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public Iterable<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    @PostMapping("/insert")
    public Product insertProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @GetMapping("/search")
    public Iterable<Product> searchProduct(@RequestParam(value = "pname",required = false ) String productName) {
        if (productName == null || productName.isEmpty()) {
            return new ArrayList<>();
        }
        return productService.searchProductByName(productName);
    }

}
