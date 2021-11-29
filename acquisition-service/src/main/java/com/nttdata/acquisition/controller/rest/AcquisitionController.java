package com.nttdata.acquisition.controller.rest;

import com.nttdata.acquisition.model.entity.Acquisition;
import com.nttdata.acquisition.model.entity.Customer;
import com.nttdata.acquisition.repository.IAcquisitionRepository;
import com.nttdata.acquisition.service.IAcquisitionService;
import com.nttdata.acquisition.service.ICustomerService;
import com.nttdata.acquisition.util.AccountRule;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/acquisition")
@RequiredArgsConstructor
public class AcquisitionController {

    private final IAcquisitionService iAcquisitionService;
    private final ICustomerService iCustomerService;

    private static final Logger Log = LoggerFactory.getLogger(AcquisitionController.class);

    @PostMapping
    public Mono<Acquisition> create(@RequestBody Acquisition acquisition){
        //return iAcquisitionService.create(acquisition);
        Mono<Acquisition> ac = iCustomerService.findById(acquisition.getCustomer().getId()).flatMap(p -> {
            acquisition.setCustomer(p);
            return Mono.just(acquisition);
        });

        //customer.subscribe(p -> Log.info(p.getCustomerType()));

        /*Mono<Acquisition> acquisitionMono = Mono.just(acquisition);
        return acquisitionMono.flatMap(a -> {
            if (a.getProductType().equals("CUENTA_AHORRO")){
                Mono<Customer> customer = iCustomerService.findById(a.getCustomer().getId());
                AccountRule accountRule = new AccountRule(a.getProductType(), customer.subscribe(v -> v.getCustomerType()).toString());
            }
            return Mono.just(acquisition);
        });*/
        return ac;
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
