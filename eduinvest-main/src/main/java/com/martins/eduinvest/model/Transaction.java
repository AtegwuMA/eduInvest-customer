package com.martins.eduinvest.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double amount;
    private String status;
    private String paymentMethod;
    private String proofOfPaymentUrl;
    @ManyToOne
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
