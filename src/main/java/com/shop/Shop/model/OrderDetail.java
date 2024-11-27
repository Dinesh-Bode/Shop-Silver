package com.shop.Shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "OrderDetail")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // Foreign key to Order
    @JoinColumn(name = "order_detail_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY) // Foreign key to Product
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "price", nullable = false)
    private Double price; //TODO Use BigDecimal for precision in prices

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

}
