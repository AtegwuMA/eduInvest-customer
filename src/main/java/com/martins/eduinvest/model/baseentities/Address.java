package com.martins.eduinvest.model.baseentities;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public final class Address {
	private Integer houseNumber;
	private String streetName;
	private String landmark;
	private String city;
	private String state;
	private String country;
}
