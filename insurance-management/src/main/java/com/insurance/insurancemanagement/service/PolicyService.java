package com.insurance.insurancemanagement.service;

import com.insurance.insurancemanagement.dto.PolicyDTO;
import com.insurance.insurancemanagement.entity.Policy;

public interface PolicyService {

	Policy save(PolicyDTO policyInput);

	PolicyDTO findByPolicyId(Long policyId);

	PolicyDTO updatePolicy(PolicyDTO policyInputDTO);

	boolean deletePolicy(Long policyId);
}
