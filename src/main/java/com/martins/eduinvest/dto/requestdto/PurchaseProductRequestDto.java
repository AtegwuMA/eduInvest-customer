package com.martins.eduinvest.dto.requestdto;

import com.martins.eduinvest.enums.ProductType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PurchaseProductRequestDto {
    @NotNull(message = "Child id is required")
    private Long childId;

    @NotNull(message = "Product type is required")
    private ProductType productType;

    @NotNull(message = "Product cost is required")
    @Positive(message = "Product cost must be greater than zero")
    private Long productCost;

    @NotNull(message = "Product duration (in months) is required")
    @Positive(message = "Product duration must be greater than zero")
    private Integer productDuration;

    private String paymentMethod;
}
