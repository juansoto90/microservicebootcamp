package com.nttdata.product.controller.rest;

import com.nttdata.product.entity.Product;
import com.nttdata.product.entity.ProductRule;
import com.nttdata.product.repository.IProductReposiroty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final IProductReposiroty iProductReposiroty;

    @GetMapping("/{id}")
    public Mono<Product> findById(@PathVariable String id){
        return iProductReposiroty.findById(id);
    }

    @PostMapping
    public Mono<Product> save(@RequestBody Product product){
        return iProductReposiroty.save(product);
    }
}
