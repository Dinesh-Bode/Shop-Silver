package com.shop.Shop.service;

import com.shop.Shop.model.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> getProducts();
    List<ProductDto> getProductById(List<Integer> productId);
}
