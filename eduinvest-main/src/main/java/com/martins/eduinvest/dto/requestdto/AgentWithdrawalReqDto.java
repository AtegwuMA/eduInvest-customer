package com.martins.eduinvest.dto.requestdto;

import jakarta.validation.constraints.*;

public class AgentWithdrawalReqDto {
    @NotNull
    @NotBlank(message = "Password is required")
    @Size(max = 20, message = "Password must be less than or equal to 20 characters")
    private String password;
    @NotNull(message = "Amount must be provided")
    @Positive(message = "Amount must be greater than zero")
    @Digits(integer = 10, fraction = 2, message = "Amount must be a valid monetary value with up to 2 decimal places.")
    private Double amount;

}
