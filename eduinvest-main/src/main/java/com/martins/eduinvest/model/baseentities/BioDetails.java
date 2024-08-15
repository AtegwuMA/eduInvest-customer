package com.martins.eduinvest.model.baseentities;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class BioDetails extends Person{

    private String phone;
    private String email;
    private String password; // Hash this in practice
    private String address;
    private boolean google2FAEnabled;

}
