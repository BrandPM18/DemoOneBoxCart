package com.root.demo.controller.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRQ {


    @Schema(example = "Product 1", description = "Product description", required = true)
    private String description;

    @Schema(example = "10.0", description = "Product price", required = true)
    private float price;
}
