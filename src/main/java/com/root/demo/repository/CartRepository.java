package com.root.demo.repository;



import com.root.demo.repository.model.Cart;

import java.util.List;

public interface CartRepository {
    List<Cart> findAll();
    Cart findById(String id);
    int save(Cart cart);
    int update(Cart cart);
    int deleteById(String id);
}
