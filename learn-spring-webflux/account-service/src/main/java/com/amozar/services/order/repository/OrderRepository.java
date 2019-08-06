package com.amozar.services.order.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;

import com.amozar.services.order.model.Order;

public interface OrderRepository extends ReactiveCrudRepository<Order, String> {

	Flux<Order> findByCustomerId(String customerId);

}
