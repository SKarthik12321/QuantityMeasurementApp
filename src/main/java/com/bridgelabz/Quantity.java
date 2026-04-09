package com.bridgelabz;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;
    private static final double EPSILON = 1e-6;

    public Quantity(double value, U unit) {
        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");
        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // ===== STATIC FACTORY (IMPORTANT FIX)
    public static Quantity<?> from(com.bridgelabz.dto.QuantityDTO dto) {
        return new Quantity<>(dto.getValue(), UnitFactory.getUnit(dto.getUnit()));
    }



    // ===== EQUALITY
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quantity<?> other)) return false;

        if (!unit.getClass().equals(other.unit.getClass()))
            return false;

        double base1 = unit.convertToBaseUnit(value);
        double base2 = ((IMeasurable) other.unit).convertToBaseUnit(other.value);

        return Math.abs(base1 - base2) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit.convertToBaseUnit(value));
    }

    // ===== CONVERSION
    public Quantity<U> convertTo(U targetUnit) {
        double base = unit.convertToBaseUnit(value);
        double converted = targetUnit.convertFromBaseUnit(base);
        return new Quantity<>(round(converted), targetUnit);
    }

    // ===== ADD
    public Quantity<U> add(Quantity<U> other) {
        double base =
                unit.convertToBaseUnit(this.value) +
                        other.unit.convertToBaseUnit(other.value);

        double result = unit.convertFromBaseUnit(base);
        return new Quantity<>(round(result), unit);
    }

    // ===== SUBTRACT
    public Quantity<U> subtract(Quantity<U> other) {
        double base =
                unit.convertToBaseUnit(this.value) -
                        other.unit.convertToBaseUnit(other.value);

        double result = unit.convertFromBaseUnit(base);
        return new Quantity<>(round(result), unit);
    }

    // ===== DIVIDE
    public double divide(Quantity<U> other) {
        double base1 = unit.convertToBaseUnit(this.value);
        double base2 = other.unit.convertToBaseUnit(other.value);

        if (Math.abs(base2) < EPSILON)
            throw new ArithmeticException("Division by zero");

        return base1 / base2;
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}