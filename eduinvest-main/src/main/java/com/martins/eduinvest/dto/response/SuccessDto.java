package com.martins.eduinvest.dto.response;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
public class SuccessDto {
    private String message;
    private String email;

    public SuccessDto(String message) {
        this.message = message;
    }


}
