package com.insurance.insurancemanagement.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.insurancemanagement.dto.CustomerDTO;
import com.insurance.insurancemanagement.entity.Customer;
import com.insurance.insurancemanagement.repository.CustomerRepository;
import com.insurance.insurancemanagement.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	private static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public Customer save(CustomerDTO customerInput) {
		Customer customer=modelMapper.map(customerInput, Customer.class);
		//TO DO validation
		return customerRepository.save(customer);
	}

	@Override
	public CustomerDTO findByTckn(String tckn) {
		Optional<Customer> customer=customerRepository.findByTckn(tckn);
		return customer.isPresent() ? modelMapper.map(customer.get(),CustomerDTO.class) : null;
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerInputDTO) {
		Customer customer=customerRepository.getOne(customerInputDTO.getId());
		if(customer == null) {
			 throw new IllegalArgumentException("Customer Does Not Exist ID:" + customerInputDTO.getId());
		}
		customer.setCustomerName(customerInputDTO.getCustomerName());
		customer.setCustomerSurname(customerInputDTO.getCustomerSurname());
		customer.setCustomerPhone(customerInputDTO.getCustomerPhone());
		customer.setCustomerAddress(customerInputDTO.getCustomerAddress());
		customer.setTckn(customerInputDTO.getTckn());
		customer.setBirthDate(customerInputDTO.getBirthDate());
		customerRepository.saveAndFlush(customer);
		
		return modelMapper.map(customer, CustomerDTO.class);
	}

	@Override
	public boolean deleteCustomer(Long customerId) {
		if(customerId!=null) {
		  customerRepository.deleteById(customerId);
		  return true;
		}
		return false;
	}
}
