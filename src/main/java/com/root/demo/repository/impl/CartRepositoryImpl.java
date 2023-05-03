package com.root.demo.repository.impl;


import com.root.demo.repository.mapper.CartMapper;
import com.root.demo.repository.CartRepository;
import com.root.demo.repository.model.Cart;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepositoryImpl implements CartRepository {

        private CartMapper cartMapper;

        public CartRepositoryImpl(CartMapper cartMapper) {
            this.cartMapper = cartMapper;
        }

        @Override
        public List<Cart> findAll() {
            return cartMapper.findAll();
        }

        @Override
        public Cart findById(String id) {
            Cart cartFromDB = cartMapper.findById(id);
            cartFromDB.setProductList(cartFromDB.castProductList());
            return cartFromDB;
        }

        @Override
        public int save(Cart cart) {
            return cartMapper.save(cart);
        }

        @Override
        public int update(Cart cart) {
            return cartMapper.update(cart);
        }
        @Override
        public int deleteById(String id) {
            return cartMapper.deleteById(id);
        }
}
