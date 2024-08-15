package com.martins.eduinvest.dto.requestdto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class ForgetPasswordDto {
    @Size(max = 100)
    @NotBlank(message = "Email Name is required")
    @Email(message = "A valid email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

}
