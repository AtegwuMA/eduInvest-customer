package com.martins.eduinvest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.martins.eduinvest.enums.ProductType;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

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
    private boolean status;

    @ManyToOne(targetEntity = Customer.class, cascade = CascadeType.DETACH)
    @JsonIgnore
    private Customer customer;

    @ManyToOne(targetEntity = Child.class, cascade = CascadeType.DETACH)
    private Child child;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    @JsonIgnore
    private Admin admin;

    // Additional fields if necessary...
}
