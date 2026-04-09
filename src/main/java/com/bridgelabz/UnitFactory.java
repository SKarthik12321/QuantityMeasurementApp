package com.bridgelabz;

public class UnitFactory {

    public static IMeasurable getUnit(String unit) {

        try { return LengthUnit.valueOf(unit); } catch (Exception ignored) {}
        try { return WeightUnit.valueOf(unit); } catch (Exception ignored) {}
        try { return VolumeUnit.valueOf(unit); } catch (Exception ignored) {}

        // REMOVE temperature if not created yet
        try { return TemperatureUnit.valueOf(unit); } catch (Exception ignored) {}

        throw new IllegalArgumentException("Invalid unit: " + unit);
    }
}
