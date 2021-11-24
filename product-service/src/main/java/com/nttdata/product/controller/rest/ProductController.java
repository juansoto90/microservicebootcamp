package com.nttdata.product.controller.rest;

import com.nttdata.product.entity.Product;
import com.nttdata.product.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final IProductRepository iProductActiveRepository;

    @GetMapping("/{id}")
    public Mono<Product> findByIdActive(@PathVariable String id){
        return iProductActiveRepository.findById(id);
    }

    @PostMapping
    public Mono<Product> saveActive(@RequestBody Product product){
        return iProductActiveRepository.save(product);
    }
}
