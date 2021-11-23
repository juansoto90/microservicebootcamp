package com.nttdata.product.service.impl;

import com.nttdata.product.entity.Product;
import com.nttdata.product.repository.IProductReposiroty;
import com.nttdata.product.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductReposiroty reposiroty;

    @Override
    public Mono<Product> findById(String id) {
        return reposiroty.findById(id);
    }

    @Override
    public Mono<Product> save(Product product) {
        return reposiroty.save(product);
    }
}
