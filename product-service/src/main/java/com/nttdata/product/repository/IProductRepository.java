package com.nttdata.product.repository;

import com.nttdata.product.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IProductRepository extends ReactiveMongoRepository<Product, String> {

}
