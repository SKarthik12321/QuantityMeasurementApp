package com.bridgelabz.repository;

import com.bridgelabz.entity.QuantityMeasurementEntity;
import java.util.List;

public interface IQuantityMeasurementRepository {

    void save(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> findAll();

    void deleteAll();

    List<QuantityMeasurementEntity> findByOperation(String operation);

    List<QuantityMeasurementEntity> findByUnit(String unit);

    int getTotalCount();

    default String getPoolStatistics() {
        return "N/A";
    }

    default void releaseResources() {}
}