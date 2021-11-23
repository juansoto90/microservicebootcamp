package com.nttdata.product.repository;

import com.nttdata.product.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface IProductReposiroty extends ReactiveMongoRepository<Product, String> {
    Mono<Product> findById(String id);
}
