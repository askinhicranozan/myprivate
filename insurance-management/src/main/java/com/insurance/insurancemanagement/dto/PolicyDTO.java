package com.insurance.insurancemanagement.dto;

import java.util.Date;

public class PolicyDTO {

	private Long id;
	private CustomerDTO customer;
	private String description;
	private String productType;
	private String productName;
	private Date time; // vade
	private Double price;// tutar

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
