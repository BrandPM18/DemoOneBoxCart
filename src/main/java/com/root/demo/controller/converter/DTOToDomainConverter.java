package com.root.demo.controller.converter;


import com.root.demo.controller.dto.request.CartRQ;
import com.root.demo.controller.dto.request.CartUpdateRQ;
import com.root.demo.controller.dto.request.ProductRQ;
import com.root.demo.service.domain.param.CartCreateParam;
import com.root.demo.service.domain.param.CartUpdateParam;
import com.root.demo.service.domain.param.ProductCreateParam;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DTOToDomainConverter {

    ProductCreateParam convert(ProductRQ productRQ);
    CartCreateParam convert(CartRQ cartRQ);
    CartUpdateParam convert(CartUpdateRQ cartRQ, String id);
}
