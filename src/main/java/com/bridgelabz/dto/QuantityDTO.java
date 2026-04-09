package com.bridgelabz.dto;

public class QuantityDTO {

    private double value;
    private String unit;
    private String measurement;

    public QuantityDTO() {}

    public QuantityDTO(double value, String unit, String measurement) {
        this.value = value;
        this.unit = unit;
        this.measurement = measurement;
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

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    @Override
    public String toString() {
        return "QuantityDTO{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                ", measurement='" + measurement + '\'' +
                '}';
    }
}
