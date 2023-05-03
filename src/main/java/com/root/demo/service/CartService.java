package com.root.demo.service;


import com.root.demo.service.domain.param.CartCreateParam;
import com.root.demo.service.domain.param.CartUpdateParam;
import com.root.demo.service.domain.result.CartCreateResult;
import com.root.demo.service.domain.result.CartDeleteResult;
import com.root.demo.service.domain.result.CartDetailResult;
import com.root.demo.service.domain.result.CartListResult;
import com.root.demo.service.domain.result.CartUpdateResult;

public interface CartService {
    CartListResult getList();
    CartDetailResult getDetail(String id);
    CartCreateResult createCart(CartCreateParam cart);
    CartUpdateResult updateCart(CartUpdateParam cart);
    CartDeleteResult deleteCart(String id);
    void cleanExpired();
}
