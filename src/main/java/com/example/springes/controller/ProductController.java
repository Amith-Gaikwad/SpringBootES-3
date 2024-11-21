package com.example.springes.controller;

import com.example.springes.entity.Product;
import com.example.springes.service.ProductService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/products/search")
    public List<Product> searchProductsByCategory(@RequestParam String category){
        if (category == null || category.isEmpty()) {
            return new ArrayList<>();
        }
        return productService.searchProductByCategory(category);
    }



    @PostMapping("/products/_search")
    public List<Product> searchByField(@RequestBody CustomSearchRequest request){
        if(request.getField() == null || request.getField().isEmpty() ||
                request.getValue() == null || request.getValue().isEmpty()){
            return new ArrayList<>();
        }
        return productService.searchByField(request.getField(), request.getValue());
    }

    @Setter
    @Getter
    public static class CustomSearchRequest {
        private String field;
        private String value;

    }


    @PostMapping("/products/_advance_search")
    public List<Product> advancedSearch(@RequestBody AdvancedSearchRequest request) {
        if (request.getField() == null || request.getField().isEmpty() ||
                request.getValue() == null || request.getValue().isEmpty()) {
            return new ArrayList<>();
        }
        System.out.println("         "+request.getField());
        System.out.println("         "+request.getValue());
        System.out.println("         "+request.getPriceLte());

        return productService.searchByAdvanceQuery(request.getField(), request.getValue(), request.getPriceLte());
    }

    @Getter
    @Setter
    public static class AdvancedSearchRequest {
        private String field;  // Field to be searched (e.g., "pname")
        private String value;  // Value to match (e.g., "Ford")
        private Double priceLte;  // Optional: Price filter (e.g., less than or equal to)
    }


}
