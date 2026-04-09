package com.bridgelabz.repository.impl;

import com.bridgelabz.entity.QuantityMeasurementEntity;
import com.bridgelabz.repository.IQuantityMeasurementRepository;

import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementCacheRepository implements IQuantityMeasurementRepository {

    private static final QuantityMeasurementCacheRepository instance = new QuantityMeasurementCacheRepository();

    private final List<QuantityMeasurementEntity> list = new ArrayList<>();

    private QuantityMeasurementCacheRepository() {}

    public static QuantityMeasurementCacheRepository getInstance() {
        return instance;
    }

    @Override
    public void save(QuantityMeasurementEntity entity) {
        list.add(entity);
    }

    @Override
    public List<QuantityMeasurementEntity> findAll() {
        return new ArrayList<>(list);
    }

    @Override
    public void deleteAll() {
        list.clear();
    }
}