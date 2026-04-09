package com.bridgelabz.repository.impl;

import com.bridgelabz.entity.QuantityMeasurementEntity;
import com.bridgelabz.repository.IQuantityMeasurementRepository;

import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementCacheRepository implements IQuantityMeasurementRepository {

    private final List<QuantityMeasurementEntity> list = new ArrayList<>();

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

    @Override
    public int getTotalCount() {
        return list.size();
    }
}