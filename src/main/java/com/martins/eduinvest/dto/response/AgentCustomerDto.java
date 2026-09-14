package com.martins.eduinvest.dto.response;

import com.martins.eduinvest.dto.response.baseresponsedto.BaseClass;
import lombok.Data;

import java.util.Date;
@Data
public class AgentCustomerDto extends BaseClass {

    private Date dob;
    private String status;
    private String state;
}
