package com.martins.eduinvest.dto.requestdto;

import com.martins.eduinvest.dto.requestdto.basedto.BaseClassReqDto;
import lombok.Data;

@Data
public class SignupRequestDto extends BaseClassReqDto {
    private String referralCode;
}
