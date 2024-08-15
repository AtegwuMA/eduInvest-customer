package com.martins.eduinvest.model;
import com.martins.eduinvest.enums.AdminRole;
import com.martins.eduinvest.model.baseentities.BioDetails;
import com.martins.eduinvest.model.baseentities.Person;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
public class Admin extends BioDetails {

    @Column(unique = true)
    private String superAdminEmail;

    private AdminRole adminRole;

    @OneToMany(mappedBy = "admin")
    private List<Agent> agents;

    @OneToMany(mappedBy = "admin")
    private List<Product> products;

    @OneToMany(mappedBy = "transaction")
    private List<Transaction> transaction;

    @OneToMany(mappedBy = "customer")
    private List<Customer> customers;
}