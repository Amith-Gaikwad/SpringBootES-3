package com.example.springes.repo;

import com.example.springes.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends ElasticsearchRepository<Product, Integer> {
    List<Product> findBypname(String pname);
}
