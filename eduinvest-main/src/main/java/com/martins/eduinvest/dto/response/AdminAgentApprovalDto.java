package com.martins.eduinvest.dto.response;

import com.martins.eduinvest.dto.response.baseresponsedto.AdminAgentBaseClass;
import lombok.Data;

@Data
public class AdminAgentApprovalDto extends AdminAgentBaseClass {

    private double availableBalance;

}
