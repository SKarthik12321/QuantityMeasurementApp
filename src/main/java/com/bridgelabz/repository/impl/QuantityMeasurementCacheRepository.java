package com.bridgelabz.repository.impl;

import com.bridgelabz.entity.QuantityMeasurementEntity;
import com.bridgelabz.repository.IQuantityMeasurementRepository;

import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementCacheRepository implements IQuantityMeasurementRepository {

    private static final QuantityMeasurementCacheRepository INSTANCE = new QuantityMeasurementCacheRepository();
    private final List<QuantityMeasurementEntity> list = new ArrayList<>();

    private QuantityMeasurementCacheRepository() {}

    public static QuantityMeasurementCacheRepository getInstance() {
        return INSTANCE;
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

    @Override
    public List<QuantityMeasurementEntity> findByOperation(String operation) {
        List<QuantityMeasurementEntity> result = new ArrayList<>();
        for (QuantityMeasurementEntity e : list) {
            if (e.getOperation().equalsIgnoreCase(operation)) {
                result.add(e);
            }
        }
        return result;
    }

    @Override
    public List<QuantityMeasurementEntity> findByUnit(String unit) {
        List<QuantityMeasurementEntity> result = new ArrayList<>();
        for (QuantityMeasurementEntity e : list) {
            if (e.getUnit().equalsIgnoreCase(unit)) {
                result.add(e);
            }
        }
        return result;
    }

    @Override
    public int getTotalCount() {
        return list.size();
    }
}