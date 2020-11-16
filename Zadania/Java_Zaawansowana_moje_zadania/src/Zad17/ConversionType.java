package Zad17;

public enum ConversionType {
    METERS_To_YARDS(1.0936f),
    YARDS_TO_METERS(0.9144f),
    CENTIMETERS_TO_INCHES(0.393700787f),
    INCHES_TO_CENTIMETERS(2.54f),
    KILOMETERS_TO_MILES(0.621371192f),
    MILES_TO_KILOMETERS(1.609344f);

    final float value;

    ConversionType(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }
}
