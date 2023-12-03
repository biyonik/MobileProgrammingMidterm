package services;

import models.RadixModel;

public class RadixConverterManager {
    public static String convert(String number, RadixModel to) {
        return Integer.toString(
                Integer.parseInt(number,10),
                to.getValue()
        );
    }
}
