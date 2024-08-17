package com.martins.eduinvest.model.baseentities;

import com.martins.eduinvest.enums.MethodFor2FA;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class BioDetails extends Person{

    @Column(nullable = false)
    private String phone;
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password; // Hash this in practice

    @Embedded
    private Address address;

    private MethodFor2FA methodFor2FA;
    private boolean google2FAEnabled;

}
