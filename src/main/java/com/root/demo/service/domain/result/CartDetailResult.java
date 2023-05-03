package com.root.demo.service.domain.result;


import com.root.demo.repository.model.Cart;
import com.root.demo.utils.DefaultResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDetailResult extends DefaultResult {
    private Cart cart;
}
