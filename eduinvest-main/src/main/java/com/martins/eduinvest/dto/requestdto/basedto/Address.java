package com.martins.eduinvest.dto.requestdto.basedto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public abstract class Address {
    @NotNull
    @Size(max = 20, message = "House number cannot exceed 20 characters.")
    private String houseNumber;
    @NotNull
    @Size(max = 20, message = "Street name cannot exceed 20 characters.")
    private String streetName;
    private String landmark;
    @NotNull
    @Size(max = 20, message = "City cannot exceed 20 characters.")
    private String city; // Location details
    @NotNull
    @Size(max = 20, message = "State cannot exceed 20 characters.")
    private String state; // Location details
    @NotNull
    @Size(max = 20, message = "Location details cannot exceed 20 characters.")
    private String countryOfOrigin;

}
