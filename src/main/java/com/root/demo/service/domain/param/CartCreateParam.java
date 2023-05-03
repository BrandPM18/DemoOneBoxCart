package com.root.demo.service.domain.param;

import com.root.demo.repository.model.Cart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartCreateParam {
    private Cart cart;
}
