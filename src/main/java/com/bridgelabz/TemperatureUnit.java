package com.bridgelabz;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS {
        @Override
        public double convertToBaseUnit(double value) {
            return value;
        }

        @Override
        public double convertFromBaseUnit(double baseValue) {
            return baseValue;
        }

        @Override
        public String getUnitName() {
            return "CELSIUS";
        }
    },

    FAHRENHEIT {
        @Override
        public double convertToBaseUnit(double value) {
            return (value - 32) * 5 / 9;
        }

        @Override
        public double convertFromBaseUnit(double baseValue) {
            return (baseValue * 9 / 5) + 32;
        }

        @Override
        public String getUnitName() {
            return "FAHRENHEIT";
        }
    },

    KELVIN {
        @Override
        public double convertToBaseUnit(double value) {
            return value - 273.15;
        }

        @Override
        public double convertFromBaseUnit(double baseValue) {
            return baseValue + 273.15;
        }

        @Override
        public String getUnitName() {
            return "KELVIN";
        }
    };

    @Override
    public double getConversionFactor() {
        return 1.0;
    }
}
