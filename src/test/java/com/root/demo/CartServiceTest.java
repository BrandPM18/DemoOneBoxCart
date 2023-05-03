package com.root.demo;

import com.root.demo.repository.CartRepository;
import com.root.demo.repository.ProductRepository;
import com.root.demo.repository.model.Cart;
import com.root.demo.repository.model.Product;
import com.root.demo.service.domain.param.CartCreateParam;
import com.root.demo.service.domain.param.CartUpdateParam;
import com.root.demo.service.domain.result.CartCreateResult;
import com.root.demo.service.domain.result.CartDeleteResult;
import com.root.demo.service.domain.result.CartDetailResult;
import com.root.demo.service.domain.result.CartListResult;
import com.root.demo.service.domain.result.CartUpdateResult;
import com.root.demo.service.impl.CartServiceImpl;
import com.root.demo.utils.StatusCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class CartServiceTest {

    private CartRepository cartRepository;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() throws IOException {
        cartRepository = Mockito.mock(CartRepository.class);
        productRepository = Mockito.mock(ProductRepository.class);
    }

    @Test
    void testCreateOk() {
        CartServiceImpl cartService = new CartServiceImpl(
                cartRepository,
                productRepository
        );
        CartCreateParam param = CartCreateParam.builder()
                .cart(Cart.builder()
                        .productList(new ArrayList<>())
                        .build())
                .build();
        CartCreateResult result = cartService.createCart(param);
        Assertions.assertEquals(StatusCode.SUCCESS, result.getStatusCode());
    }

    @Test
    void testGetAllOk() {
        CartServiceImpl cartService = new CartServiceImpl(
                cartRepository,
                productRepository
        );
        Mockito.when(cartRepository.findAll()).thenReturn(List.of(mockCart()));

        CartListResult result = cartService.getList();
        Assertions.assertEquals(StatusCode.SUCCESS, result.getStatusCode());
    }

    @Test
    void testGetIdOk() {
        CartServiceImpl cartService = new CartServiceImpl(
                cartRepository,
                productRepository
        );
        Mockito.when(cartRepository.findById(Mockito.anyString())).thenReturn(mockCart());

        String id = "123";
        CartDetailResult result = cartService.getDetail(id);
        Assertions.assertEquals(StatusCode.SUCCESS, result.getStatusCode());
    }
    @Test
    void testUpdateCartOk() {
        CartServiceImpl cartService = new CartServiceImpl(
                cartRepository,
                productRepository
        );
        CartUpdateParam param = CartUpdateParam.builder()
                .addToCart(true)
                .cart(Cart.builder()
                        .id(UUID.randomUUID().toString())
                        .productList(List.of(1))
                        .build())
                .build();
        Mockito.when(cartRepository.findById(Mockito.anyString())).thenReturn(mockCart());
        Mockito.when(productRepository.findById(Mockito.anyInt())).thenReturn(mockProduct());
        CartUpdateResult result = cartService.updateCart(param);
        Assertions.assertEquals(StatusCode.SUCCESS, result.getStatusCode());
    }

    @Test
    void testDeleteCartOk() {
        CartServiceImpl cartService = new CartServiceImpl(
                cartRepository,
                productRepository
        );
        String id = "123";
        CartDeleteResult result = cartService.deleteCart(id);
        Assertions.assertEquals(StatusCode.SUCCESS, result.getStatusCode());
    }

    private Cart mockCart() {
        return Cart.builder()
                .id(UUID.randomUUID().toString())
                .productList(List.of(2))
                .creationUser("test")
                .creationDate(LocalDateTime.now())
                .build();
    }

    private Product mockProduct() {
        return Product.builder()
                .id(1)
                .description("Product 1")
                .amount(10.0F)
                .build();
    }

}