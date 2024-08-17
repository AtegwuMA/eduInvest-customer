package com.martins.eduinvest.model;

import com.martins.eduinvest.enums.CustomerType;
import com.martins.eduinvest.model.baseentities.BioDetails;
import com.martins.eduinvest.model.baseentities.Person;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Customer extends BioDetails {

    private CustomerType customerType;

    @OneToMany
    @JoinColumn(name = "child_id", referencedColumnName = "id")
    private Set<Child> childSet = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "product-id", referencedColumnName = "id")
    private Set<Product> productSet = new HashSet<>();

    @OneToMany
    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    private Set<Transaction> transactionSet = new HashSet<>();


}