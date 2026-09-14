package com.martins.eduinvest.dto.requestdto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class LoginRequestDto {
    @Size(max = 100)
    @NotBlank(message = "Email is required")
    @Email(message = "A valid email is required")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(max = 20, message = "Password must be less than or equal to 20 characters")
    private String password;

}
