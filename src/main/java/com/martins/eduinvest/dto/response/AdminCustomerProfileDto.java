package com.martins.eduinvest.dto.response;

import com.martins.eduinvest.dto.response.baseresponsedto.BaseClassResDto;
import com.martins.eduinvest.enums.IdentificationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminCustomerProfileDto extends BaseClassResDto {

    private Date signupDate;
    private boolean verificationStatus;
    private IdentificationType identificationType;

}
