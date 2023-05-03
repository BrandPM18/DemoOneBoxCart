package com.root.demo.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    @Schema(description = "Cart identifier UUID", example = "123e4567-e89b-12d3-a456-426614174000")
    private UUID id;

    @Schema(example = "30.2", description = "Total price of the cart", required = true)
    private float totalPrice;

    @Schema(description = "List of products in the cart", example = "[1,2,3]", required = true)
    private List<Integer> productListIds;

    @Schema(example = "user", description = "User who created the cart")
    private String creationUser;

    @Schema(example = "user", description = "User who modified the cart")
    private String modificationUser;

    @Schema(example = "2021-01-01", description = "Date when the cart was created")
    private LocalDateTime creationDate;

    @Schema(example = "2021-01-01", description = "Date when the cart was modified")
    private LocalDateTime modificationDate;
}