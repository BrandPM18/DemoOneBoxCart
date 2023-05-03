package com.root.demo.service.domain.result;

import com.root.demo.repository.model.Product;
import com.root.demo.utils.DefaultResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListResult extends DefaultResult {
    private List<Product> products;

}
