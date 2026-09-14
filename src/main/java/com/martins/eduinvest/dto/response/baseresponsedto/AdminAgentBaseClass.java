package com.martins.eduinvest.dto.response.baseresponsedto;

import com.martins.eduinvest.enums.AgentStatus;
import lombok.Data;

import java.util.Date;
@Data
public abstract class AdminAgentBaseClass extends BaseClassResDto {
    private AgentStatus agentStatus;
    private Long totalReferralsCount;
    private String referralCode;
    private Double referralBonus; //points Earned
    private Double conversionRate;
    private Integer pointsEarned;
    private boolean identityVerified;
}
