package com.bridgelabz.entity;

import java.io.Serializable;

public class QuantityMeasurementEntity implements Serializable {

    private double value;
    private String unit;

    public QuantityMeasurementEntity(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return "Entity[value=" + value + ", unit=" + unit + "]";
    }
}