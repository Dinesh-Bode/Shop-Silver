package com.shop.Shop.controller;

import com.shop.Shop.model.dto.ProductDto;
import com.shop.Shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> productDto = productService.getProducts();
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

}
