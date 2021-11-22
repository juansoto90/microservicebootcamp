package com.nttdata.customer.repository;

import com.nttdata.customer.repository.entity.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ICustomerRepository extends ReactiveCrudRepository<Customer, String> {
    Mono<Customer> findByName(String name);
    Mono<Customer> findByCustomerIdNumber(String customerIdName);
}
