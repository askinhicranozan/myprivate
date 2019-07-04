package com.insurance.insurancemanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.insurancemanagement.dto.PolicyDTO;
import com.insurance.insurancemanagement.entity.Policy;
import com.insurance.insurancemanagement.responseEntity.ApiError;
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
  public Long saveCustomer(@Validated @RequestBody PolicyDTO savePolicyInputDTO)
      throws Exception {
    logger.info("Saving policyInfo");
    Policy policy = policyService.save(savePolicyInputDTO);
    return policy.getId();
  }

  @RequestMapping(value = "/searchPolicy/{policyId}", method = RequestMethod.GET)
  public ApiResponse searchPolicy(@PathVariable("policyId") Long policyId) {
    logger.info("Search policy by id");
    PolicyDTO policy = policyService.findByPolicyId(policyId);
    if (policy != null) {
      return new ApiResponse(ApiResponseStatus.SUCCESS, policy);
    } else {
      List<ApiError> errors = new ArrayList<>();
      errors.add(new ApiError("404", "No policy found"));
      return new ApiResponse(ApiResponseStatus.ERROR, policy, errors);
    }
  }

  @RequestMapping(value = "/updatePolicy", method = RequestMethod.POST)
  public ApiResponse updateCustomer(
      @Validated @RequestBody PolicyDTO policyInputDTO) throws Exception {
    logger.info("update method policyService calling...");
    PolicyDTO policy = policyService.updatePolicy(policyInputDTO);
    return new ApiResponse(ApiResponseStatus.SUCCESS, policy);
  }

  @RequestMapping(value = "/deletePolicy/{id}", method = RequestMethod.GET)
  public ApiResponse deletePolicy(@PathVariable("policyId") Long policyId) {
    logger.info("delete method policyService calling...");
    boolean result = policyService.deletePolicy(policyId);
    return new ApiResponse(ApiResponseStatus.SUCCESS, result);
  }

}
