package com.root.demo.controller.dto.response;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartCreateRS {

    @Schema(description = "Cart identifier UUID", example = "123e4567-e89b-12d3-a456-556642440000")
    private UUID id;
}
