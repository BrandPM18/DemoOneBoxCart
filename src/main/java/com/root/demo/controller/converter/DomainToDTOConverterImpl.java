package com.root.demo.controller.converter;



import com.root.demo.controller.dto.CartDTO;
import com.root.demo.controller.dto.ProductDTO;
import com.root.demo.controller.dto.response.CartCreateRS;
import com.root.demo.controller.dto.response.CartListRS;
import com.root.demo.controller.dto.response.ProductCreateRS;
import com.root.demo.controller.dto.response.ProductListRS;
import com.root.demo.repository.model.Cart;
import com.root.demo.repository.model.Product;
import com.root.demo.service.domain.result.CartCreateResult;
import com.root.demo.service.domain.result.CartDetailResult;
import com.root.demo.service.domain.result.CartListResult;
import com.root.demo.service.domain.result.ProductCreateResult;
import com.root.demo.service.domain.result.ProductDetailResult;
import com.root.demo.service.domain.result.ProductListResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class DomainToDTOConverterImpl implements DomainToDTOConverter {
    @Override
    public ProductDTO convert(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .description(product.getDescription())
                .price(product.getAmount())
                .build();
    }

    @Override
    public CartDTO convert(Cart cart) {
        return CartDTO.builder()
                .id(UUID.fromString(cart.getId()))
                .creationUser(cart.getCreationUser())
                .creationDate(cart.getCreationDate())
                .modificationDate(cart.getModificationDate())
                .modificationUser(cart.getModificationUser())
                .totalPrice(cart.getTotalPrice())
                .productListIds(cart.castProductList())
                .build();
    }

    @Override
    public ProductDTO convert(ProductDetailResult productDetailUseCaseResult) {
        return ProductDTO.builder()
                .id(productDetailUseCaseResult.getProduct().getId())
                .description(productDetailUseCaseResult.getProduct().getDescription())
                .price(productDetailUseCaseResult.getProduct().getAmount())
                .build();
    }

    @Override
    public CartDTO convert(CartDetailResult cartListUseCaseResult) {
        return CartDTO.builder()
                .id(UUID.fromString(cartListUseCaseResult.getCart().getId()))
                .creationUser(cartListUseCaseResult.getCart().getCreationUser())
                .creationDate(cartListUseCaseResult.getCart().getCreationDate())
                .modificationDate(cartListUseCaseResult.getCart().getModificationDate())
                .modificationUser(cartListUseCaseResult.getCart().getModificationUser())
                .totalPrice(cartListUseCaseResult.getCart().getTotalPrice())
                .productListIds(cartListUseCaseResult.getCart().getProductList())
                .build();
    }

    @Override
    public CartCreateRS convert(CartCreateResult cartCreateUseCaseResult) {
        return CartCreateRS.builder()
                .id(cartCreateUseCaseResult.getId())
                .build();
    }

    @Override
    public ProductListRS convert(ProductListResult productListUseCaseResult) {
        return ProductListRS.builder()
                .products(List.of(productListUseCaseResult.getProducts().stream().map(this::convert).toArray(ProductDTO[]::new)))
                .build();
    }
    @Override
    public ProductCreateRS convert(ProductCreateResult productCreateUseCaseResult) {
        return ProductCreateRS.builder()
                .id(productCreateUseCaseResult.getId())
                .build();
    }

    @Override
    public CartListRS convert(CartListResult cartListUseCaseResult) {
        return CartListRS.builder()
                .carts(List.of(cartListUseCaseResult.getCarts().stream().map(this::convert).toArray(CartDTO[]::new)))
                .build();
    }
}
