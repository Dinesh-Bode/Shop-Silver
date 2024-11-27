package com.shop.Shop.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private Integer productId;
    private String productName;
    private Integer price;
    private Integer availableQuantity;
    private String imageUrl;
    private String category;
}
