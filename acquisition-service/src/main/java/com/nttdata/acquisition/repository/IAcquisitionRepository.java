package com.nttdata.acquisition.repository;

import com.nttdata.acquisition.model.entity.Acquisition;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IAcquisitionRepository extends ReactiveMongoRepository<Acquisition, String> {
}
