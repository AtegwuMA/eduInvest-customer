package com.martins.eduinvest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.martins.eduinvest.enums.CustomerType;
import com.martins.eduinvest.model.baseentities.BioDetails;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Customer extends BioDetails {

    private CustomerType customerType;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    @JsonIgnore
    private Agent referredBy;

    @OneToMany(mappedBy = "customer")
    private Set<Child> childSet = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<Product> productSet = new HashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<Transaction> transactionSet = new HashSet<>();

}
