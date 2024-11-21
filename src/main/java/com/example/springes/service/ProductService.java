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
    public List<Product> searchProductByCategory(String category){
        return productRepo.findByCategory(category);
    }





    public List<Product> searchByField(String field, String value){
        return productRepo.searchByField(field, value);
    }




    public List<Product> searchByAdvanceQuery(String field, String value, Double price){
        System.out.println("The Price here $$$$$$$$$$$$    "+price+"      $$$$$$$$");
        if(price != null){
            return productRepo.searchByCustomQuery(field, value, price);
        }
        else{
            return productRepo.searchByField(field, value);
        }
    }

}
