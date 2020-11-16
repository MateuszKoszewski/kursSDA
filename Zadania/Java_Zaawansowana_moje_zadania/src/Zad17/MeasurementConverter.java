package Zad17;

public class MeasurementConverter {

    public float convert(int value, ConversionType conversionType){
            return value * conversionType.getValue();
    }
}
