package com.root.demo.controller.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartUpdateRQ {
    @Schema(description = "List of products in the cart", example = "[1,2,3]", required = true)
    private List<Integer> productListIds;

    @Schema(description = "Add to cart", example = "true", required = true)
    private boolean addToCart;
    @Schema(example = "user", description = "User who modified the cart")
    private String modificationUser;
}
