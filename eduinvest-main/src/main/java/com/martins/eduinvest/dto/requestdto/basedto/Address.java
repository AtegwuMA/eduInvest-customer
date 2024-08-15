package com.martins.eduinvest.dto.requestdto.basedto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public abstract class Address {
    @NotNull
    @Size(max = 20, message = "Location details cannot exceed 20 characters.")
    private String streetNameAndNumber;
    @NotNull
    @Size(max = 20, message = "Location details cannot exceed 20 characters.")
    private String city; // Location details
    @NotNull
    @Size(max = 20, message = "Location details cannot exceed 20 characters.")
    private String state; // Location details
    @NotNull
    @Size(max = 20, message = "Location details cannot exceed 20 characters.")
    private String countryOfOrigin;
    @NotNull
    @Size(min = 5, max = 400, message = "The address should be between 5 and 400 characters.")
    private String addressDetails;
}
