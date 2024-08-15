package com.martins.eduinvest.model;

import com.martins.eduinvest.model.baseentities.Person;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
public class Child extends Person {

    private String schoolType; // e.g., Nursery, Primary, Secondary
    private String investmentType; // e.g., WAEC, NECO, JAMB

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Additional fields...
    private String schoolName;
    private String schoolAddress;
    private String classType; // e.g., Class 1, Class 2
}
