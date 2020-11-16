package Zad8;

public class Validator implements iValidator {

    private final static int maxSummaryDimensions = 300;
    private final static int maxSingleDimension = 30;
    private final static float maxWeightForExpress = 15;
    private final static float maxWeightForTypical = 30;

    @Override
    public boolean validate(Parcel input) {
        if (input.getxLength() + input.getyLength() + input.getzLength() > maxSummaryDimensions) {
            System.out.println("wrong max summary dimensions");
            return false;
        }
        if (input.getxLength() > maxSingleDimension || input.getyLength() > maxSingleDimension || input.getzLength() > maxSingleDimension) {
            System.out.println("wrong single dimension");
            return false;
        }
        if ((input.isExpress() && input.getWeight() > maxWeightForExpress) || (!input.isExpress() && input.getWeight() > maxWeightForTypical)) {
            System.out.println("wrong weight");
            return false;
        }
        System.out.println("parcel is ok");
        return true;
    }
}
