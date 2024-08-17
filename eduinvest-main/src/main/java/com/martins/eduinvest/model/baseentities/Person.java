package com.martins.eduinvest.model.baseentities;
import com.martins.eduinvest.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@MappedSuperclass
@Data
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, updatable = false)
    private Gender gender;

    @Column(nullable = false)
    private Date dob;

}