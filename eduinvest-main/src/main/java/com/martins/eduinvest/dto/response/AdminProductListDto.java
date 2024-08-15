package com.martins.eduinvest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class AdminProductListDto {

    private Date createdDate;
    private Integer totalProducts;
    private Integer activeProducts;
    private Integer offlineProducts;
    private String productName;
    private String productAmount;
    private String productPurchases;
    private boolean status;
}
