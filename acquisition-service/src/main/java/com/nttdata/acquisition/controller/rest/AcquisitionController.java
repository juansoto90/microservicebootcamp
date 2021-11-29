package com.nttdata.acquisition.controller.rest;

import com.nttdata.acquisition.model.entity.Acquisition;
import com.nttdata.acquisition.model.entity.Customer;
import com.nttdata.acquisition.repository.IAcquisitionRepository;
import com.nttdata.acquisition.service.IAcquisitionService;
import com.nttdata.acquisition.service.ICustomerService;
import com.nttdata.acquisition.util.AccountRule;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/acquision")
@RequiredArgsConstructor
public class AcquisitionController {

    private final IAcquisitionService iAcquisitionService;
    private final ICustomerService iCustomerService;

    @PostMapping
    public Mono<Acquisition> create(@RequestBody Acquisition acquisition){
        //return iAcquisitionService.create(acquisition);
        Mono<Acquisition> acquisitionMono = Mono.just(acquisition);
        return acquisitionMono.flatMap(a -> {
            if (a.getProductType().equals("CUENTA_AHORRO")){
                Mono<Customer> customer = iCustomerService.findById(a.getId());
                AccountRule accountRule = new AccountRule(a.getProductType(), customer.subscribe(v -> v.getCustomerType()).toString());
            }
            return Mono.just(acquisition);
        });
    }

    @PutMapping
    public Mono<Acquisition> update(Acquisition acquisition){
        return iAcquisitionService.update(acquisition);
    }

    @DeleteMapping
    public Mono<Void> deleteById(String id){
        return iAcquisitionService.deleteById(id);
    }
}
