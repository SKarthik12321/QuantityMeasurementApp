package com.bridgelabz.service.impl;

import com.bridgelabz.*;
import com.bridgelabz.dto.QuantityDTO;
import com.bridgelabz.service.IQuantityMeasurementService;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    @Override
    public boolean compare(QuantityDTO q1, QuantityDTO q2) {
        Quantity<?> a = Quantity.from(q1);
        Quantity<?> b = Quantity.from(q2);
        return a.equals(b);
    }

    @Override
    public QuantityDTO convert(QuantityDTO dto, String targetUnit) {
        Quantity<?> q = Quantity.from(dto);
        IMeasurable target = UnitFactory.getUnit(targetUnit);

        Quantity result = ((Quantity) q).convertTo(target);

        return new QuantityDTO(result.getValue(), result.getUnit().getUnitName());
    }

    @Override
    public QuantityDTO add(QuantityDTO q1, QuantityDTO q2) {
        Quantity a = (Quantity) Quantity.from(q1);
        Quantity b = (Quantity) Quantity.from(q2);

        Quantity result = a.add(b);

        return new QuantityDTO(result.getValue(), result.getUnit().getUnitName());
    }

    @Override
    public QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2) {
        Quantity a = (Quantity) Quantity.from(q1);
        Quantity b = (Quantity) Quantity.from(q2);

        Quantity result = a.subtract(b);

        return new QuantityDTO(result.getValue(), result.getUnit().getUnitName());
    }

    @Override
    public double divide(QuantityDTO q1, QuantityDTO q2) {
        Quantity a = (Quantity) Quantity.from(q1);
        Quantity b = (Quantity) Quantity.from(q2);

        return a.divide(b);
    }
}