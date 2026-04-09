package com.bridgelabz.service;

import com.bridgelabz.dto.QuantityDTO;

public interface IQuantityMeasurementService {

    QuantityDTO compare(QuantityDTO q1, QuantityDTO q2);

    QuantityDTO convert(QuantityDTO input, String targetUnit);

    QuantityDTO add(QuantityDTO q1, QuantityDTO q2);

    QuantityDTO subtract(QuantityDTO q1, QuantityDTO q2);

    QuantityDTO divide(QuantityDTO q1, QuantityDTO q2);
}
