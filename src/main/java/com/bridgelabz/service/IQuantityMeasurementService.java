package com.bridgelabz.service;

import com.bridgelabz.entity.QuantityMeasurementEntity;
import java.util.List;

public interface IQuantityMeasurementService {

    QuantityMeasurementEntity save(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> getAll();

    long getTotalCount();
}