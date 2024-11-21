package com.example.springes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "product_index")
public class Product {

    private int id;
    private String pname;

    @Field(type = FieldType.Keyword)
    private String category;
    private int qty;
    private double price;
}
