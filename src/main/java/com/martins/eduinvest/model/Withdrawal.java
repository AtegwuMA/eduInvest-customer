package com.martins.eduinvest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.martins.eduinvest.enums.WithdrawalStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Withdrawal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date requestedAt = new Date();
    private Date paidAt;
    private Double amount;
    private WithdrawalStatus status = WithdrawalStatus.PENDING;

    @ManyToOne
    @JoinColumn(name = "agent_id")
    @JsonIgnore
    private Agent agent;
}
