package com.bridgelabz.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "quantity_measurement")
public class QuantityMeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double value;
    private String unit;
    private String operation;
    private double result;

    public QuantityMeasurementEntity() {}

    public QuantityMeasurementEntity(double value, String unit, String operation, double result) {
        this.value = value;
        this.unit = unit;
        this.operation = operation;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}