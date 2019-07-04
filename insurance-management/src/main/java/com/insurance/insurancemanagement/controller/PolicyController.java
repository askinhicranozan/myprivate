package com.insurance.insurancemanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.insurancemanagement.dto.CustomerDTO;
import com.insurance.insurancemanagement.dto.PolicyDTO;
import com.insurance.insurancemanagement.entity.Policy;
import com.insurance.insurancemanagement.responseEntity.ApiResponse;
import com.insurance.insurancemanagement.responseEntity.ApiResponseStatus;
import com.insurance.insurancemanagement.service.PolicyService;

@RestController
@RequestMapping("/api/v1/policy")
public class PolicyController {

	@Autowired
	private PolicyService policyService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/savePolicy", method = RequestMethod.POST)
	public ApiResponse saveCustomer(@Validated @RequestBody PolicyDTO savePolicyInputDTO) throws Exception {

		if (isDTOEmpty(savePolicyInputDTO)) {

			logger.warn("You have to enter at least 1 search parameter!");
			return new ApiResponse(ApiResponseStatus.ERROR, "You have to enter at least 1 search parameter!");

		} else {

			logger.info("Saving policyInfo");
			Policy policy = policyService.save(savePolicyInputDTO);
			return new ApiResponse(ApiResponseStatus.SUCCESS, policy);
		}
	}
	
	
	@RequestMapping(value = "/listPolicy/{id}", method = RequestMethod.GET)
	public ApiResponse listCustomer(@PathVariable("policyId")Long policyId){
		logger.info("List policy by id");
		List<PolicyDTO> policyList=policyService.findByPolicyId(policyId);
		return new ApiResponse(ApiResponseStatus.SUCCESS,policyList);
	}
	
	
	
	@RequestMapping(value = "/updatePolicy", method = RequestMethod.POST)
	public ApiResponse updateCustomer(@Validated @RequestBody PolicyDTO policyInputDTO) throws Exception {
		logger.info("update method policyService calling...");
		PolicyDTO policy = policyService.updatePolicy(policyInputDTO);
		return new ApiResponse(ApiResponseStatus.SUCCESS, policy);
	}
	
	
	@RequestMapping(value = "/deletePolicy/{id}", method = RequestMethod.GET)
	public ApiResponse deletePolicy(@PathVariable("policyId")Long policyId){
		logger.info("delete method policyService calling...");
		Boolean result=policyService.deletePolicy(policyId);
		return new ApiResponse(ApiResponseStatus.SUCCESS,result);
	}


	private boolean isDTOEmpty(PolicyDTO inputDTO) {
		if (inputDTO == null) {
			return true;
		} else if (StringUtils.isEmpty(inputDTO.getCustomer()) && StringUtils.isEmpty(inputDTO.getDescription())
				&& StringUtils.isEmpty(inputDTO.getPrice()) && inputDTO.getId() == null
				&& StringUtils.isEmpty(inputDTO.getProductName()) && StringUtils.isEmpty(inputDTO.getProductType())
				&& StringUtils.isEmpty(inputDTO.getTime())) {
			return true;
		}
		return false;
	}
}
