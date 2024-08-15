package com.martins.eduinvest.model.baseentities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@MappedSuperclass
@Data
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Date dob;

}