package com.martins.eduinvest.model;

import com.martins.eduinvest.model.baseentities.BioDetails;
import com.martins.eduinvest.model.baseentities.Person;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Customer extends BioDetails {

    @OneToMany(mappedBy = "customer")
    private List<Child> children;

    @OneToMany(mappedBy = "customer")
    private List<Transaction> transactions;

}