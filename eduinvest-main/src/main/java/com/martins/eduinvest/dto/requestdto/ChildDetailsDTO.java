package com.martins.eduinvest.dto.requestdto;


import com.martins.eduinvest.enums.Gender;
import com.martins.eduinvest.model.baseentities.Address;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import lombok.Builder;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Builder
@Validated
public record ChildDetailsDTO(
				@Column(nullable = false, updatable = false)
				String firstName,
				@Column(nullable = false, updatable = false)
				String lastName,
				@Column(nullable = false, updatable = false)
				Gender gender,
				@Column(nullable = false, updatable = false)
				LocalDateTime dob,

				@AttributeOverride(name = "houseNumber", column = @Column(name = "number"))
				@AttributeOverride(name = "street", column = @Column(name = "street/road"))
				@AttributeOverride(name = "landmark", column = @Column(name = "zip"))
				Address SchoolAddress
				) {
}
