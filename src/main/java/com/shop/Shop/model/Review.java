package com.shop.Shop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Review")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;

    @ManyToOne(fetch = FetchType.LAZY) // Foreign key to User
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY) // Foreign key to Product
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "heading", nullable = false, length = 100)
    private String heading;

    @Column(name = "rating", nullable = false)
    private Integer rating; // Assuming a 1-5 star rating system

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "photo_url")
    private String photoUrls;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

}
