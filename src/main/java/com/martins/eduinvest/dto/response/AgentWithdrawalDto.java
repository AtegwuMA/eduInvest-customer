package com.martins.eduinvest.dto.response;

import lombok.Data;

import java.util.Date;
@Data
public class AgentWithdrawalDto {
    private Long totalReferrals;
    private Double referralBonus;
    private Double minWithdrawal;
    private String regNo;
    private Double amount;
    private Date date;
    private String status;
    private Double balance;
    private String bankName;
    private String accountNumber;
}
