package com.insurance.insurancemanagement.service.impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.insurancemanagement.dto.PolicyDTO;
import com.insurance.insurancemanagement.entity.Policy;
import com.insurance.insurancemanagement.repository.PolicyRepository;
import com.insurance.insurancemanagement.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService{
	
	@Autowired
	private PolicyRepository policyRepository;
	
	private static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public Policy save(PolicyDTO policyInput) {
		Policy policy=modelMapper.map(policyInput, Policy.class);
		//TO DO validation
		return policyRepository.save(policy);
	}

	@Override
	public List<PolicyDTO> findByPolicyId(Long policyId) {
		List<Policy> policy=policyRepository.findAll();
		return Arrays.asList(modelMapper.map(policy,PolicyDTO.class));
	}

	@Override
	public PolicyDTO updatePolicy(PolicyDTO policyInputDTO) {
		Policy policy=policyRepository.getOne(policyInputDTO.getId());
		if(policy == null) {
			 throw new IllegalArgumentException("Policy Does Not Exist ID:" + policyInputDTO.getId());
		}
		policy.setDescription(policyInputDTO.getDescription());
		policy.setPrice(policyInputDTO.getPrice());
		policy.setProductName(policyInputDTO.getProductName());
		policy.setProductType(policyInputDTO.getProductType());
		policy.setTime(policyInputDTO.getTime());
		//policy.setCustomer(policyInputDTO.getCustomer();
		
		policyRepository.saveAndFlush(policy);
		
		return modelMapper.map(policy, PolicyDTO.class);
	}

	@Override
	public Boolean deletePolicy(Long policyId) {
		Boolean result=false;
		if(policyId!=null) {
			policyRepository.deleteById(policyId);
		result=true;
		}
		return result;
	}

}
