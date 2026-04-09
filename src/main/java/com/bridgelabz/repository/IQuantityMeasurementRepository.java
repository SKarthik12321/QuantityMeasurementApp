package com.bridgelabz.repository;

import com.bridgelabz.entity.QuantityMeasurementEntity;
import java.util.List;

public interface IQuantityMeasurementRepository {

    void save(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> findAll();

    void deleteAll();

    // UC16 extra (optional but expected)
    default int getTotalCount() {
        return findAll().size();
    }
}