package com.bridgelabz.entity;

import java.io.Serializable;

public class QuantityMeasurementEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Double value1;
    private String unit1;

    private Double value2;
    private String unit2;

    private String operation;

    private Double result;
    private String resultUnit;

    private boolean error;
    private String errorMessage;

    // Constructor for single operand (conversion)
    public QuantityMeasurementEntity(Double value1, String unit1, String operation,
                                     Double result, String resultUnit) {
        this.value1 = value1;
        this.unit1 = unit1;
        this.operation = operation;
        this.result = result;
        this.resultUnit = resultUnit;
        this.error = false;
    }

    // Constructor for two operands (add, subtract, compare, divide)
    public QuantityMeasurementEntity(Double value1, String unit1,
                                     Double value2, String unit2,
                                     String operation,
                                     Double result, String resultUnit) {
        this.value1 = value1;
        this.unit1 = unit1;
        this.value2 = value2;
        this.unit2 = unit2;
        this.operation = operation;
        this.result = result;
        this.resultUnit = resultUnit;
        this.error = false;
    }

    // Constructor for error
    public QuantityMeasurementEntity(String operation, String errorMessage) {
        this.operation = operation;
        this.errorMessage = errorMessage;
        this.error = true;
    }

    public boolean isError() {
        return error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Double getResult() {
        return result;
    }

    public String getResultUnit() {
        return resultUnit;
    }

    @Override
    public String toString() {
        if (error) {
            return "Error in " + operation + ": " + errorMessage;
        }

        if (value2 != null) {
            return value1 + " " + unit1 + " " + operation + " " +
                    value2 + " " + unit2 + " = " +
                    result + " " + resultUnit;
        }

        return value1 + " " + unit1 + " " + operation + " = " +
                result + " " + resultUnit;
    }
}