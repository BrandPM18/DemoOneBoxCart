package com.root.demo.service;


import com.root.demo.service.domain.param.ProductCreateParam;
import com.root.demo.service.domain.param.ProductDetailParam;
import com.root.demo.service.domain.result.ProductCreateResult;
import com.root.demo.service.domain.result.ProductDetailResult;
import com.root.demo.service.domain.result.ProductListResult;

public interface ProductService {
    ProductListResult getList();
    ProductDetailResult getProductDetail(ProductDetailParam param);
    ProductCreateResult createProduct(ProductCreateParam param);
}
