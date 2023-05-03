package com.root.demo.repository;


import com.root.demo.repository.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();
    Product findById(Integer id);
    Integer save(Product product);
}
