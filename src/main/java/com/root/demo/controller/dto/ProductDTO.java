package com.root.demo.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @Schema(example = "1", description = "Product identifier")
    private Integer id;
    @Schema(example = "Product 1", description = "Product description")
    private String description;

    @Schema(example = "10.0", description = "Product price")
    private float price;
}

