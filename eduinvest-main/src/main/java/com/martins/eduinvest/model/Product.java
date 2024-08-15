package com.martins.eduinvest.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate createdDate;
    private LocalDate expirationDate;
    private Double quantity;
    private Double thresholdQuantity;
    private Double amount;
    private boolean status;
//    private boolean activeProduct;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    // Additional fields if necessary...
}
