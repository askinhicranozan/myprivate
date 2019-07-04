package com.insurance.insurancemanagement.service;

import java.util.List;

import com.insurance.insurancemanagement.dto.PolicyDTO;
import com.insurance.insurancemanagement.entity.Policy;

public interface PolicyService {

	Policy save(PolicyDTO policyInput);

	List<PolicyDTO> findByPolicyId(Long policyId);

	PolicyDTO updatePolicy(PolicyDTO policyInputDTO);

	Boolean deletePolicy(Long policyId);
}
