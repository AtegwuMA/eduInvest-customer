package com.martins.eduinvest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@RequiredArgsConstructor
public class AdminProductListDto {

    private LocalDate purchaseDate;
    private Integer totalProducts;
    private Integer activeProducts;
    private Integer offlineProducts;
    private String productType;
    private String productCost;
    private String productPurchases;
    private boolean status;
}
