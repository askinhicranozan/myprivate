package com.insurance.insurancemanagement.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "policy")
@Getter @Setter
public class Policy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "description")
	private String description;

	@Column(name = "productType")
	private String productType;

	@Column(name = "productName")
	private String productName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time")
	private Date time;

	@Column(name = "price")
	private BigDecimal price;

	@ManyToOne(fetch=FetchType.LAZY )
	@JoinColumn(name = "CUSTOMER_ID")
	private Customer customer;

}
