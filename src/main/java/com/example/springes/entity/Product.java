package com.example.springes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "product_index")
public class Product {

    private int id;
    private String pname;
    private int qty;
    private double price;
}