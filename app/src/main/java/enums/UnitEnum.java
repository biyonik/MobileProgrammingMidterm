package enums;

public enum UnitEnum {
    BIT(8 * Math.pow(1024, 2)),
    BYTE(Math.pow(1024, 2)),
    KIBIBYTE(Math.pow(10, 6) / Math.pow(2,10)),
    KILOBYTE(1024);

    private double value;

    UnitEnum(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
