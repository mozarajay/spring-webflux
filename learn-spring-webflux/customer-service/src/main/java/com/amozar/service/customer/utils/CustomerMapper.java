package com.amozar.service.customer.utils;

import java.util.List;

import com.amozar.service.customer.model.Customer;

public class CustomerMapper {

	public static Customer map(List<Customer> customers) {
		Customer customer = new Customer();
		for (Customer c : customers) {
			if (c.getOrders() != null) customer.setOrders(c.getOrders());
			if (c.getAge() != 0) customer.setAge(c.getAge());
			if (c.getFirstName() != null) customer.setFirstName(c.getFirstName());
			if (c.getLastName() != null) customer.setFirstName(c.getLastName());
		}
		return customer;
	}

}
