package com.amozar.service.customer.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.amozar.service.customer.model.Customer;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {
	
}
