package com.root.demo.repository.impl;


import com.root.demo.repository.ProductRepository;
import com.root.demo.repository.mapper.ProductMapper;
import com.root.demo.repository.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    private ProductMapper productMapper;

    public ProductRepositoryImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> findAll() {
        return productMapper.findAll();
    }
    @Override
    public Product findById(Integer id) {
        return productMapper.findById(id);
    }
    @Override
    public Integer save(Product product) {
        return productMapper.save(product);
    }
}
