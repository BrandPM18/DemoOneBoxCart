package com.root.demo.service.impl;

import com.root.demo.repository.ProductRepository;
import com.root.demo.repository.model.Product;
import com.root.demo.service.ProductService;
import com.root.demo.utils.StatusCode;
import com.root.demo.service.domain.param.ProductCreateParam;
import com.root.demo.service.domain.param.ProductDetailParam;
import com.root.demo.service.domain.result.ProductCreateResult;
import com.root.demo.service.domain.result.ProductDetailResult;
import com.root.demo.service.domain.result.ProductListResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductListResult getList() {
        ProductListResult result = new ProductListResult();
        try {
            List<Product> productList = productRepository.findAll();
            result.setProducts(productList);
            result.setStatusCode(StatusCode.SUCCESS);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ProductListResult.builder()
                    .statusCode(StatusCode.ERROR)
                    .build();
        }

        return result;
    }

    @Override
    public ProductDetailResult getProductDetail(ProductDetailParam param) {
        ProductDetailResult result = new ProductDetailResult();
        try {
            Product product = productRepository.findById(param.getId());
            result.setProduct(product);
            result.setStatusCode(StatusCode.SUCCESS);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ProductDetailResult.builder()
                    .statusCode(StatusCode.ERROR)
                    .build();
        }
        return result;
    }

    @Override
    public ProductCreateResult createProduct(ProductCreateParam param) {
        ProductCreateResult result = new ProductCreateResult();
        try {
            Integer id = productRepository.save(param.getProduct());
            result.setId(id);
            result.setStatusCode(StatusCode.SUCCESS);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return ProductCreateResult.builder()
                    .statusCode(StatusCode.ERROR)
                    .build();
        }
        return result;
    }
}
