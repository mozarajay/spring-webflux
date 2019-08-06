package com.amozar.service.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.amozar.service.customer.model.Order;
import com.amozar.service.customer.model.Customer;
import com.amozar.service.customer.repository.CustomerRepository;
import com.amozar.service.customer.utils.CustomerMapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerRepository repository;
	@Autowired
    private WebClient.Builder webClientBuilder;

	@GetMapping("/{id}")
	public Mono<Customer> findById(@PathVariable("id") String id) {
		LOGGER.info("findById: id={}", id);
		return repository.findById(id);
	}

	@GetMapping
	public Flux<Customer> findAll() {
		LOGGER.info("findAll");
		return repository.findAll();
	}

	@GetMapping("/{id}/with-orders")
	public Mono<Customer> findByIdWithOrders(@PathVariable("id") String id) {
		LOGGER.info("findByIdWithOrder: id={}", id);
		Flux<Order> Orders = webClientBuilder.build().get().uri("http://order-service/customer/{customer}", id).retrieve().bodyToFlux(Order.class);
		return Orders
				.collectList()
				.map(a -> new Customer(a))
				.mergeWith(repository.findById(id))
				.collectList()
				.map(CustomerMapper::map);
	}

	@PostMapping
	public Mono<Customer> create(@RequestBody Customer customer) {
		LOGGER.info("create: {}", customer);
		return repository.save(customer);
	}

}
