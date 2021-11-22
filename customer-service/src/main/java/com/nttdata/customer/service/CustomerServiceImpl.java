package com.nttdata.customer.service;

import com.nttdata.customer.repository.ICustomerRepository;
import com.nttdata.customer.repository.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerRepository repository;

    @Override
    public Mono<Customer> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Mono<Customer> findByCustomerIdNumber(String customerIdName) {
        return repository.findByCustomerIdNumber(customerIdName);
    }

    @Override
    public Mono<Customer> save(Customer customer) {
        return repository.save(customer);
    }
}
