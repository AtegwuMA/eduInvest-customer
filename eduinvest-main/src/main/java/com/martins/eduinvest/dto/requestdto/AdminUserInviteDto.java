package com.martins.eduinvest.dto.requestdto;

import com.martins.eduinvest.dto.requestdto.basedto.BaseClassReqDto;
import com.martins.eduinvest.enums.AdminRole;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminUserInviteDto extends BaseClassReqDto {
    @Enumerated
    private AdminRole adminRole;
}