package com.insurance.insurancemanagement.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter @Setter
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name", unique = true)
	private String customerName;

	@Column(name = "surname", length = 200)
	private String customerSurname;

	@Column(name = "tckn")
	private String tckn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthDate")
	private Date birthDate;

	@Column(name = "phone")
	private String customerPhone;

	@Column(name = "address")
	private String customerAddress;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Policy> policies = new ArrayList<Policy>();


}
