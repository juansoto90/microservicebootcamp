package com.nttdata.customer.service;

import com.nttdata.customer.entity.Customer;
import reactor.core.publisher.Mono;

public interface ICustomerService {
    Mono<Customer> findByName(String name);
    Mono<Customer> findByCustomerIdNumber(String customerIdName);
    Mono<Customer> save(Customer customer);
}
