package com.martins.eduinvest.dto.response;

import com.martins.eduinvest.dto.response.baseresponsedto.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminAgentCustomerListDto extends BaseClass {
    private Integer numberOfChildren;
    private boolean status;
}