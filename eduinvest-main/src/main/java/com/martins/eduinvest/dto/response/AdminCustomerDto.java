package com.martins.eduinvest.dto.response;

import com.martins.eduinvest.dto.response.baseresponsedto.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminCustomerDto extends BaseClass {

    private Integer totalCustomers;
    private Integer activeCustomers;
    private Integer inactiveCustomers;
    private Integer blockedCustomers;
    private Integer totalLiens;
    private Integer numberOfChildren;
    private boolean status;
}
