package com.martins.eduinvest.dto.response;

import com.martins.eduinvest.dto.response.baseresponsedto.AdminAgentBaseClass;
import com.martins.eduinvest.dto.response.baseresponsedto.BaseClassResDto;
import com.martins.eduinvest.enums.AgentStatus;
import com.martins.eduinvest.enums.IdentificationType;
import com.martins.eduinvest.model.Customer;
import lombok.Data;

import java.util.Date;
import java.util.List;
@Data
public class AgentResponseDto extends AdminAgentBaseClass {
    private List<Customer> referrals;
    private boolean emailVerified;

}
