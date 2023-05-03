package com.root.demo.service.domain.result;


import com.root.demo.utils.DefaultResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartCreateResult extends DefaultResult {
    private UUID id;
}
