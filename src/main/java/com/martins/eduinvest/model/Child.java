package com.martins.eduinvest.model;

import com.martins.eduinvest.enums.CustomerToChildRelationship;
import com.martins.eduinvest.enums.ProductType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.martins.eduinvest.model.baseentities.Address;
import com.martins.eduinvest.model.baseentities.Person;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Child extends Person {
    private CustomerToChildRelationship toChildRelationship;

    private String schoolType; // e.g., Nursery, Primary, Secondary
    private ProductType productType;  //investmentType: e.g., WAEC, NECO, JAMB

    // Additional fields...
    private String schoolName;
    private Address schoolAddress;
    private String classType; // e.g., Class 1, Class 2

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;
}
