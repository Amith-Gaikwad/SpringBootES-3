package com.example.springes.repo;

import com.example.springes.entity.Product;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends ElasticsearchRepository<Product, Integer> {
    List<Product> findBypname(String pname);
    List<Product> findByCategory(String category);


    @Query("{\"match\": {\"?0\": \"?1\"}}")
    List<Product> searchByField(String field, String value);


    @Query("{\"bool\": {\"must\": [{\"match\": {\"?0\": \"?1\"}}], \"filter\": [{\"range\": {\"price\": {\"lte\": ?2}}}]}}")
    List<Product> searchByCustomQuery(String field, String value, Double priceLte);




}
