package com.insurance.insurancemanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.insurancemanagement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

  Optional<Customer> findById(Long id);

  Optional<Customer> findByTckn(String tckn);

}
