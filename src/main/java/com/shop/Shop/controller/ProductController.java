package com.shop.Shop.controller;

import com.shop.Shop.model.dto.ProductDto;
import com.shop.Shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3001")
public class ProductController {

    @Autowired
    private ProductService productService;

    @QueryMapping
    public List<ProductDto> getAllProducts() {
        return productService.getProducts();
    }

    @QueryMapping
    public List<ProductDto> productsByIds(@Argument List<Integer> productIds) {
        return productService.getProductById(productIds);
    }
}
