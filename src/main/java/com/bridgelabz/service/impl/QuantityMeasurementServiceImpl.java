package com.bridgelabz.service.impl;

import com.bridgelabz.Quantity;
import com.bridgelabz.UnitFactory;
import com.bridgelabz.dto.QuantityDTO;
import com.bridgelabz.entity.QuantityMeasurementEntity;
import com.bridgelabz.repository.IQuantityMeasurementRepository;
import com.bridgelabz.service.IQuantityMeasurementService;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private final IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean compare(QuantityDTO q1, QuantityDTO q2) {
        Quantity<?> a = Quantity.from(q1);
        Quantity<?> b = Quantity.from(q2);
        boolean result = a.equals(b);

        repository.save(new QuantityMeasurementEntity(
                q1.getValue(), q1.getUnit(), "COMPARE", result ? 1 : 0
        ));

        return result;
    }

    @Override
    public QuantityDTO convert(QuantityDTO dto, String targetUnit) {
        Quantity<?> q = Quantity.from(dto);
        Quantity result = ((Quantity) q).convertTo(UnitFactory.getUnit(targetUnit));

        repository.save(new QuantityMeasurementEntity(
                dto.getValue(), dto.getUnit(), "CONVERT", result.getValue()
        ));

        return new QuantityDTO(result.getValue(), result.getUnit().getUnitName());
    }

    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {
        Quantity<?> a = Quantity.from(q1);
        Quantity<?> b = Quantity.from(q2);
        Quantity result = ((Quantity) a).add((Quantity) b);

        repository.save(new QuantityMeasurementEntity(
                q1.getValue(), q1.getUnit(), "ADD", result.getValue()
        ));

        return new QuantityDTO(result.getValue(), result.getUnit().getUnitName());
    }

    @Override
    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {
        Quantity<?> a = Quantity.from(q1);
        Quantity<?> b = Quantity.from(q2);
        Quantity result = ((Quantity) a).subtract((Quantity) b);

        repository.save(new QuantityMeasurementEntity(
                q1.getValue(), q1.getUnit(), "SUBTRACT", result.getValue()
        ));

        return new QuantityDTO(result.getValue(), result.getUnit().getUnitName());
    }

    @Override
    public double divide(QuantityDTO q1, QuantityDTO q2) {
        Quantity<?> a = Quantity.from(q1);
        Quantity<?> b = Quantity.from(q2);
        double result = ((Quantity) a).divide((Quantity) b);

        repository.save(new QuantityMeasurementEntity(
                q1.getValue(), q1.getUnit(), "DIVIDE", result
        ));

        return result;
    }
}