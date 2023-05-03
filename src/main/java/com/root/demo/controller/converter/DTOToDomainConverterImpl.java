package com.root.demo.controller.converter;


import com.root.demo.controller.dto.request.CartRQ;
import com.root.demo.controller.dto.request.CartUpdateRQ;
import com.root.demo.controller.dto.request.ProductRQ;
import com.root.demo.repository.model.Cart;
import com.root.demo.repository.model.Product;
import com.root.demo.service.domain.param.CartCreateParam;
import com.root.demo.service.domain.param.CartUpdateParam;
import com.root.demo.service.domain.param.ProductCreateParam;
import org.springframework.stereotype.Component;

@Component
public class DTOToDomainConverterImpl implements DTOToDomainConverter {

    @Override
    public ProductCreateParam convert(ProductRQ productRQ) {
        return ProductCreateParam.builder()
                .product(Product.builder()
                        .description(productRQ.getDescription())
                        .amount(productRQ.getPrice())
                        .build())
                .build();
    }
    @Override
    public CartCreateParam convert(CartRQ cartRQ) {
        return CartCreateParam.builder()
                .cart(Cart.builder()
                        .creationUser(cartRQ.getCreationUser())
                        .products(cartRQ.getProductListIds().toString())
                        .productList(cartRQ.getProductListIds())
                        .build())
                .build();
    }

    @Override
    public CartUpdateParam convert(CartUpdateRQ cartRQ, String id) {
        return CartUpdateParam.builder()
                .addToCart(cartRQ.isAddToCart())
                .cart(Cart.builder()
                        .id(id)
                        .modificationUser(cartRQ.getModificationUser())
                        .products(cartRQ.getProductListIds().toString())
                        .productList(cartRQ.getProductListIds())
                        .build())
                .build();
    }
}
