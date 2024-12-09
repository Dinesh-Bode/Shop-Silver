package com.shop.Shop.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.Shop.model.Product;
import com.shop.Shop.model.dto.ProductDto;
import com.shop.Shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<ProductDto> getProducts() {
        List<Product> productList = productRepository.findAll();

        return productList.stream()
                .map(value -> objectMapper.convertValue(value, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> getProductById(List<Integer> productIds) {
        List<Product> productList = productRepository.findAllById(productIds);
        return productList.stream()
                .map(value -> objectMapper.convertValue(value, ProductDto.class))
                .collect(Collectors.toList());
    }

    public ProductDto createProductDto(Product product) {

        return ProductDto.builder()
                .productId(product.getProductId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .category(product.getCategory())
                .availableQuantity(product.getAvailableQuantity())
                .imageUrl(product.getImageUrl())
                .description(product.getDescription())
                .build();
    }
}
