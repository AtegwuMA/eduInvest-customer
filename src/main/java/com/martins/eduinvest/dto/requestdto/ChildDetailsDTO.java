package com.martins.eduinvest.dto.requestdto;

import com.martins.eduinvest.enums.Gender;
import com.martins.eduinvest.model.baseentities.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ChildDetailsDTO(
                @NotBlank String firstName,
                @NotBlank String lastName,
                @NotNull Gender gender,
                @NotNull LocalDate dob,
                String schoolName,
                String schoolType,
                Address schoolAddress
                ) {
}
