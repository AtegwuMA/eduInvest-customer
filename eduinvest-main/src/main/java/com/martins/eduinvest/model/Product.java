package com.martins.eduinvest.model;

import com.martins.eduinvest.enums.ProductType;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long productCost;
    private ProductType productType;
    private Integer productDuration;
    private LocalDate purchaseDate;
    private Integer totalProducts;
    private Integer activeProducts;
    private Integer offlineProducts;
    private boolean status;

    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.DETACH)
    private Customer customer;

    @ManyToOne(targetEntity = Child.class, cascade = CascadeType.DETACH)
    private Child child;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    // Additional fields if necessary...
}
