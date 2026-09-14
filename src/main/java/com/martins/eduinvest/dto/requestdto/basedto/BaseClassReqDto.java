package com.martins.eduinvest.dto.requestdto.basedto;

import com.martins.eduinvest.enums.Gender;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class BaseClassReqDto {

    @NotBlank(message = "First Name is required")
    private String firstName;

    @NotBlank(message = "Last Name is required")
    private String lastName;

    @NotNull(message = "Gender is required")
    private Gender gender;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid phone number format")
    private String phone;

    @Size(max = 100)
    @NotBlank(message = "Email Name is required")
    @Email(message = "A valid email is required")
    @Column(unique = true)
    private String email;

    @NotNull
    @NotBlank(message = "Password Name is required")
    @Size(max = 20, message = "Password must be less than or equal to 20 characters")
    @Size(min = 8, message = "Password must be more than or equal to 8 characters")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()-+=]).{8,}$", message = "Password must contain at least 8 characters, one digit, one lowercase letter, one uppercase letter, and one special character")
    private String password;

}
