package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    // UC1 - Feet

    @Test
    void givenSameFeetValue_WhenCompared_ShouldReturnTrue() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(1.0);
        assertTrue(f1.equals(f2));
    }

    @Test
    void givenDifferentFeetValue_WhenCompared_ShouldReturnFalse() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        QuantityMeasurementApp.Feet f2 = new QuantityMeasurementApp.Feet(2.0);
        assertFalse(f1.equals(f2));
    }

    @Test
    void givenNullFeet_WhenCompared_ShouldReturnFalse() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        assertFalse(f1.equals(null));
    }

    @Test
    void givenSameReferenceFeet_WhenCompared_ShouldReturnTrue() {
        QuantityMeasurementApp.Feet f1 = new QuantityMeasurementApp.Feet(1.0);
        assertTrue(f1.equals(f1));
    }

    // UC2 - Inch

    @Test
    void givenSameInchValue_WhenCompared_ShouldReturnTrue() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(12.0);
        QuantityMeasurementApp.Inch i2 = new QuantityMeasurementApp.Inch(12.0);
        assertTrue(i1.equals(i2));
    }

    @Test
    void givenDifferentInchValue_WhenCompared_ShouldReturnFalse() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(12.0);
        QuantityMeasurementApp.Inch i2 = new QuantityMeasurementApp.Inch(24.0);
        assertFalse(i1.equals(i2));
    }

    @Test
    void givenNullInch_WhenCompared_ShouldReturnFalse() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(12.0);
        assertFalse(i1.equals(null));
    }

    @Test
    void givenSameReferenceInch_WhenCompared_ShouldReturnTrue() {
        QuantityMeasurementApp.Inch i1 = new QuantityMeasurementApp.Inch(12.0);
        assertTrue(i1.equals(i1));
    }
}