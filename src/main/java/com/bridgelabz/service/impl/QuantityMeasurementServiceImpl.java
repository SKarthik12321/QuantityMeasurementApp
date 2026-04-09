package com.bridgelabz.service.impl;

import com.bridgelabz.Quantity;
import com.bridgelabz.IMeasurable;
import com.bridgelabz.entity.QuantityMeasurementEntity;
import com.bridgelabz.repository.IQuantityMeasurementRepository;
import com.bridgelabz.service.IQuantityMeasurementService;

import java.util.concurrent.atomic.AtomicLong;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private final IQuantityMeasurementRepository repository;
    private final AtomicLong idGenerator = new AtomicLong(1);

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    @Override
    public <U extends IMeasurable> boolean compare(Quantity<U> q1, Quantity<U> q2) {
        boolean result = q1.equals(q2);
        save(q1, "COMPARE");
        return result;
    }

    @Override
    public <U extends IMeasurable> Quantity<U> convert(Quantity<U> quantity, U targetUnit) {
        Quantity<U> result = quantity.convertTo(targetUnit);
        save(result, "CONVERT");
        return result;
    }

    @Override
    public <U extends IMeasurable> Quantity<U> add(Quantity<U> q1, Quantity<U> q2) {
        Quantity<U> result = q1.add(q2);
        save(result, "ADD");
        return result;
    }

    @Override
    public <U extends IMeasurable> Quantity<U> add(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        Quantity<U> result = q1.add(q2, targetUnit);
        save(result, "ADD");
        return result;
    }

    @Override
    public <U extends IMeasurable> Quantity<U> subtract(Quantity<U> q1, Quantity<U> q2) {
        Quantity<U> result = q1.subtract(q2);
        save(result, "SUBTRACT");
        return result;
    }

    @Override
    public <U extends IMeasurable> Quantity<U> subtract(Quantity<U> q1, Quantity<U> q2, U targetUnit) {
        Quantity<U> result = q1.subtract(q2, targetUnit);
        save(result, "SUBTRACT");
        return result;
    }

    @Override
    public <U extends IMeasurable> double divide(Quantity<U> q1, Quantity<U> q2) {
        double result = q1.divide(q2);
        save(q1, "DIVIDE");
        return result;
    }

    private <U extends IMeasurable> void save(Quantity<U> quantity, String operation) {
        QuantityMeasurementEntity entity = new QuantityMeasurementEntity(
                idGenerator.getAndIncrement(),
                quantity.getValue(),
                quantity.getUnit().getUnitName(),
                operation
        );
        repository.save(entity);
    }
}
