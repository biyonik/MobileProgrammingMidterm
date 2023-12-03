package services;

public class HeatConverterManager {
    public static String convertToCelciusToFahrenheit(String celcius) {
        Double celciusDouble = Double.parseDouble(celcius);
        Double result = celciusDouble * 1.8 + 32;
        return result.toString();
    }

    public static String convertToCelciusToKelvin(String celcius) {
        Double celciusDouble = Double.parseDouble(celcius);
        Double result = celciusDouble + 273.15;
        return result.toString();
    }
}
