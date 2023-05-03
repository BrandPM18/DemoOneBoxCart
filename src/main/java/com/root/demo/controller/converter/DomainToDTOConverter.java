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
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DomainToDTOConverter {
    ProductDTO convert(Product product);
    CartDTO convert(Cart cart);
    ProductListRS convert(ProductListResult productListUseCaseResult);
    ProductDTO convert(ProductDetailResult productDetailUseCaseResult);
    ProductCreateRS convert(ProductCreateResult productCreateUseCaseResult);
    CartListRS convert(CartListResult cartListUseCaseResult);
    CartDTO convert(CartDetailResult cartListUseCaseResult);
    CartCreateRS convert(CartCreateResult cartCreateUseCaseResult);

}
