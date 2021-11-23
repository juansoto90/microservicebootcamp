package com.nttdata.product.service;

import com.nttdata.product.entity.Product;
import reactor.core.publisher.Mono;

public interface IProductService {
    Mono<Product> findById(String id);
    Mono<Product> save(Product product);
}
