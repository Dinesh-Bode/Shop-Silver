package com.shop.Shop.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDto {

    private Integer productId;
    private String productName;
    private Double price;
    private Integer availableQuantity;
    private String imageUrl;
    private String category;
    private String description;

}
