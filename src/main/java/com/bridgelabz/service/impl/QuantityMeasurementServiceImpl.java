package com.bridgelabz.service.impl;

import com.bridgelabz.model.QuantityMeasurementEntity;
import com.bridgelabz.repository.QuantityMeasurementRepository;
import com.bridgelabz.service.IQuantityMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    @Autowired
    private QuantityMeasurementRepository repository;

    @Override
    public QuantityMeasurementEntity save(QuantityMeasurementEntity entity) {
        return repository.save(entity);
    }

    @Override
    public List<QuantityMeasurementEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public int getTotalCount() {
        return (int) repository.count();
    }
}