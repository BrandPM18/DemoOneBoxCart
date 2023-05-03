package com.root.demo.controller.dto.response;


import com.root.demo.controller.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductListRS {
    private List<ProductDTO> products;
}
