package com.root.demo.service.domain.result;

import com.root.demo.repository.model.Cart;
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
public class CartListResult extends DefaultResult {
    private List<Cart> carts;
}
