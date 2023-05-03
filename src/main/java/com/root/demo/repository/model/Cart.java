package com.root.demo.repository.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private String id;
    private float totalPrice;
    private String products;
    private String creationUser;
    private String modificationUser;
    private LocalDateTime creationDate;
    private LocalDateTime modificationDate;
    private transient List<Integer> productList;
    public List<Integer> castProductList() {
        List<Integer> productList = new ArrayList<>();
        if (this.products != null) {
            products = this.products.replaceAll("\"\\[|\\]\"", "");
            if(!products.isEmpty()) {
                productList = Arrays.stream(products.split(","))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
            }
        }
        return productList;
    }

    public boolean isExpired() {
        return this.modificationDate.isBefore(LocalDateTime.now().minusMinutes(10));
    }
}
