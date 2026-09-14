package com.martins.eduinvest.dto.response.baseresponsedto;

import lombok.Data;

import java.util.Date;
@Data
public abstract class BaseClassResDto extends BaseClass {

    private Date dob;
    private String countryOfOrigin;
    private String streetNameAndNumber;
    private String city;
    private String state; //Location
    private String accountName;
    private String bankName;
    private String accountNumber;
    private boolean google2FAEnabled;
}
