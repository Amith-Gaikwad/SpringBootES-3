package com.example.springes.service;

import com.example.springes.entity.Product;
import com.example.springes.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Iterable<Product> getAllProduct(){
        return productRepo.findAll();
    }

    public Product insertProduct(Product product){
        return productRepo.save(product);
    }

    public List<Product> searchProductByName(String name){
        return productRepo.findBypname(name);
    }

}
