package com.bridgelabz.service;

import com.bridgelabz.model.QuantityMeasurementEntity;
import java.util.List;

public interface IQuantityMeasurementService {

    QuantityMeasurementEntity save(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> getAll();

    void deleteAll();

    int getTotalCount();
}