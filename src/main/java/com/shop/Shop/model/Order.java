package com.shop.Shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "Order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment for primary key
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY) // Foreign key relationship with User
    @JoinColumn(name = "user_id", nullable = false) // Maps user_id as a foreign key
    private User user;

    @Column(name = "payment_mode", nullable = false, length = 50)
    private String paymentMode;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @Column(name = "total_amount", nullable = false)
    private Double totalAmount; //TODO Use BigDecimal for monetary values

    @Column(name = "discount")
    private Double discount;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

}
