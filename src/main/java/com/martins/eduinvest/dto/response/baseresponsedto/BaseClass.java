package com.martins.eduinvest.dto.response.baseresponsedto;

import lombok.Data;

@Data
public abstract class BaseClass {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone; //mobileNumber;
    private String email;
}
