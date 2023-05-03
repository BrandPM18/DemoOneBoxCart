package com.root.demo.service.domain.param;


import com.root.demo.repository.model.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCreateParam {
    private Product product;
}
