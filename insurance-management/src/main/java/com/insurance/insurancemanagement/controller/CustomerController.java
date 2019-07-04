package com.insurance.insurancemanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.insurancemanagement.dto.CustomerDTO;
import com.insurance.insurancemanagement.entity.Customer;
import com.insurance.insurancemanagement.responseEntity.ApiError;
import com.insurance.insurancemanagement.responseEntity.ApiResponse;
import com.insurance.insurancemanagement.responseEntity.ApiResponseStatus;
import com.insurance.insurancemanagement.service.CustomerService;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public Long saveCustomer(@Validated @RequestBody CustomerDTO saveCustomerInputDTO) throws Exception {
		logger.info("Saving customer");
		Customer customer = customerService.save(saveCustomerInputDTO);
		return customer.getId();
	}
	
	@RequestMapping(value = "/searchCustomer/{tckn}", method = RequestMethod.GET)
	public ApiResponse searchCustomer(@PathVariable("tckn") String tckn){
		logger.info("Searching customer by tckn");
		CustomerDTO customer = customerService.findByTckn(tckn);
		if (customer != null) {
		  return new ApiResponse(ApiResponseStatus.SUCCESS, customer);
        } else {
          List<ApiError> errors = new ArrayList<>();
          errors.add(new ApiError("404", "No customer found"));
          return new ApiResponse(ApiResponseStatus.ERROR, customer, errors );
        }
		
	}
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public ApiResponse updateCustomer(@Validated @RequestBody CustomerDTO customerInputDTO) throws Exception {
		logger.info("update method customerService calling...");
		CustomerDTO customer = customerService.updateCustomer(customerInputDTO);
		return new ApiResponse(ApiResponseStatus.SUCCESS, customer);
	}
	
	@RequestMapping(value = "/deleteCustomer/{customerId}", method = RequestMethod.GET)
	public ApiResponse deleteCustomer(@PathVariable("customerId")Long customerId){
		logger.info("delete method customerService calling...");
		boolean result=customerService.deleteCustomer(customerId);
		return new ApiResponse(ApiResponseStatus.SUCCESS,result);
	}

}
