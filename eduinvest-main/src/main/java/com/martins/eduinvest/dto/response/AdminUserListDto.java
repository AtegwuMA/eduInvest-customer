package com.martins.eduinvest.dto.response;

import com.martins.eduinvest.enums.AdminRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminUserListDto {

    private String firstname;
    private String lastname;
    private boolean inviteStatus;
    private boolean status;
    private Date inviteDate;
    private AdminRole adminRole;

}