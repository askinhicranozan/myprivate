package com.insurance.insurancemanagement.service;

import com.insurance.insurancemanagement.dto.CustomerDTO;
import com.insurance.insurancemanagement.entity.Customer;

public interface CustomerService {

	Customer save(CustomerDTO customerInput);
	CustomerDTO findByTckn(String tckn);
	CustomerDTO updateCustomer(CustomerDTO customerInputDTO);
	boolean deleteCustomer(Long customerId);
}
