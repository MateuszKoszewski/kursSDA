package Zad17;

public class ConverterMain {

    public static void main(String[] args) {
        MeasurementConverter converter = new MeasurementConverter();

        System.out.println(converter.convert(10, ConversionType.CENTIMETERS_TO_INCHES));
        System.out.println(converter.convert(10, ConversionType.INCHES_TO_CENTIMETERS));
        System.out.println(converter.convert(10, ConversionType.KILOMETERS_TO_MILES));
        System.out.println(converter.convert(10, ConversionType.MILES_TO_KILOMETERS));
        System.out.println(converter.convert(10, ConversionType.YARDS_TO_METERS));
        System.out.println(converter.convert(10, ConversionType.METERS_To_YARDS));


    }
}
