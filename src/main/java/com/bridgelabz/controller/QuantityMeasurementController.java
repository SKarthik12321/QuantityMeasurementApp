package com.bridgelabz.controller;

import com.bridgelabz.dto.QuantityDTO;
import com.bridgelabz.service.IQuantityMeasurementService;

public class QuantityMeasurementController {

    private final IQuantityMeasurementService service;

    public QuantityMeasurementController(IQuantityMeasurementService service) {
        this.service = service;
    }

    public String add(QuantityDTO q1, QuantityDTO q2) {
        try {
            return service.add(q1, q2).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String subtract(QuantityDTO q1, QuantityDTO q2) {
        try {
            return service.subtract(q1, q2).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String convert(QuantityDTO q, String targetUnit) {
        try {
            return service.convert(q, targetUnit).toString();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public double divide(QuantityDTO q1, QuantityDTO q2) {
        return service.divide(q1, q2);
    }

    public boolean compare(QuantityDTO q1, QuantityDTO q2) {
        return service.compare(q1, q2);
    }
}
