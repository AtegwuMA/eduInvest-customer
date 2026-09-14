package com.martins.eduinvest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.martins.eduinvest.enums.AgentStatus;
import com.martins.eduinvest.enums.IdentificationType;
import com.martins.eduinvest.model.baseentities.BioDetails;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Agent extends BioDetails {

    private String accountName;
    private String accountNumber;
    private String bankName;
    private IdentificationType identificationType;
    private String idUpload;
    private boolean identityVerified;

    private AgentStatus agentStatus = AgentStatus.PENDING;
    private Long totalReferralsCount = 0L;
    @Column(unique = true)
    private String referralCode;
    private Double referralBonus = 0.0;
    private Double conversionRate;
    private boolean emailVerified;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    @JsonIgnore
    private Admin admin;

    @OneToMany(mappedBy = "agent")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "referredBy")
    private List<Customer> referrals;

    @OneToMany(mappedBy = "agent")
    private List<Withdrawal> withdrawals;
}
