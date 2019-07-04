package com.insurance.insurancemanagement.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.insurance.insurancemanagement.entity.Customer;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PolicyDTO {

	private Long id;
	
	@NotNull(message = "Please provide a customer for the policy")
	private Customer customer;
	
	private String description;
	
	@NotEmpty(message = "Please provide a product type")
	private String productType;
	
	@NotEmpty(message = "Please provide a product name")
	private String productName;
	private Date time; // vade
	
	@NotNull(message = "Please provide a price")
    @DecimalMin("0.01")
	private BigDecimal price;// tutar

}
