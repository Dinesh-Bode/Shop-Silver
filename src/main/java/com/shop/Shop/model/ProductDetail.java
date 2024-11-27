package com.shop.Shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_detail", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_detail_id")
    private Integer productDetailId;

    @Column(name = "product_id") //Foreign key
    private Integer productId;

    @Column(name = "size")
    private String size;

    @Column(name = "price")
    private Double price;

    @Column(name = "available_qty")
    private String availableQty;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "length")
    private Double length;

}
