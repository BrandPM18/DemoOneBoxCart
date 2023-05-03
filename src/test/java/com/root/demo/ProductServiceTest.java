package com.root.demo;

import com.root.demo.repository.ProductRepository;
import com.root.demo.repository.model.Product;
import com.root.demo.service.domain.param.ProductCreateParam;
import com.root.demo.service.domain.param.ProductDetailParam;
import com.root.demo.service.domain.result.ProductCreateResult;
import com.root.demo.service.domain.result.ProductDetailResult;
import com.root.demo.service.domain.result.ProductListResult;
import com.root.demo.service.impl.ProductServiceImpl;
import com.root.demo.utils.StatusCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductServiceTest {

    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = Mockito.mock(ProductRepository.class);
    }

    @Test
    public void testGetAllOk() {
        Mockito.when(productRepository.findAll()).thenReturn(List.of(mockProduct()));
        ProductServiceImpl productService = new ProductServiceImpl(productRepository);

        ProductListResult result = productService.getList();
        Assertions.assertEquals(StatusCode.SUCCESS, result.getStatusCode());
    }

    @Test
    public void testGetDetailOk() {
        Mockito.when(productRepository.findById(Mockito.anyInt())).thenReturn(mockProduct());
        ProductServiceImpl productService = new ProductServiceImpl(productRepository);

        ProductDetailParam param = ProductDetailParam.builder()
                .id(1)
                .build();

        ProductDetailResult result = productService.getProductDetail(param);
        Assertions.assertEquals(StatusCode.SUCCESS, result.getStatusCode());
    }

    @Test
    public void testCreateProductOk() {
        Mockito.when(productRepository.save(Mockito.any())).thenReturn(1);
        ProductServiceImpl productService = new ProductServiceImpl(productRepository);

        ProductCreateParam param = ProductCreateParam.builder()
                .product(Product.builder()
                        .description("Product 1")
                        .amount(10.0F)
                        .build())
                .build();

        ProductCreateResult result = productService.createProduct(param);
        Assertions.assertEquals(StatusCode.SUCCESS, result.getStatusCode());
    }



    private Product mockProduct() {
        return Product.builder()
                .id(1)
                .description("Product 1")
                .amount(10.0F)
                .build();
    }
}
