package services;

import enums.UnitEnum;

public class UnitConverter {
    public static double convert(String megabyte, UnitEnum unit) {
        return Double.parseDouble(megabyte) * unit.getValue();
    }
}
