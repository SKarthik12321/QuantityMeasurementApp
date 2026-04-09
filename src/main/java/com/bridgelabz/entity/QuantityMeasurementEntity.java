package com.bridgelabz.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class QuantityMeasurementEntity implements Serializable {

    private Long id;
    private double value;
    private String unit;
    private String operation;
    private LocalDateTime timestamp;

    public QuantityMeasurementEntity() {
        this.timestamp = LocalDateTime.now();
    }

    public QuantityMeasurementEntity(Long id, double value, String unit, String operation) {
        this.id = id;
        this.value = value;
        this.unit = unit;
        this.operation = operation;
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public String getUnit() {
        return unit;
    }

    public String getOperation() {
        return operation;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
