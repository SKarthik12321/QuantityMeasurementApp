package com.bridgelabz.service.impl;

import com.bridgelabz.entity.QuantityMeasurementEntity;
import com.bridgelabz.repository.QuantityMeasurementRepository;
import com.bridgelabz.service.IQuantityMeasurementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private final QuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(QuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    @Override
    public QuantityMeasurementEntity save(QuantityMeasurementEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<QuantityMeasurementEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public long getTotalCount() {
        return repository.count();
    }
}