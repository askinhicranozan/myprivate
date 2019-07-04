package com.insurance.insurancemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.insurancemanagement.entity.Customer;
import com.insurance.insurancemanagement.entity.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

}
