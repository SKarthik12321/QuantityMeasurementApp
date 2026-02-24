package com.bridgelabz;

public class QuantityMeasurementApp {

    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        public double toInch() {
            return value * 12;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null)
                return false;

            if (obj instanceof Feet) {
                Feet feet = (Feet) obj;
                return Double.compare(this.value, feet.value) == 0;
            }

            if (obj instanceof Inch) {
                Inch inch = (Inch) obj;
                return Double.compare(this.toInch(), inch.value) == 0;
            }

            return false;
        }
    }

    public static class Inch {
        private final double value;

        public Inch(double value) {
            this.value = value;
        }

        public double toFeet() {
            return value / 12;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;

            if (obj == null)
                return false;

            if (obj instanceof Inch) {
                Inch inch = (Inch) obj;
                return Double.compare(this.value, inch.value) == 0;
            }

            if (obj instanceof Feet) {
                Feet feet = (Feet) obj;
                return Double.compare(this.value, feet.toInch()) == 0;
            }

            return false;
        }
    }
}