package calc;

import java.util.List;

public class Parsing {

    public static FinData romanToArabic(RawData rawData) {

        List<RomanNumeral> romanNumerals = RomanNumeral.getValues();
        FinData newData = new FinData(0, 0, true);
        int i = 0;

        while ((rawData.num1.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (rawData.num1.startsWith(symbol.name())) {
                newData.num1 += symbol.getValue();
                rawData.num1 = rawData.num1.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        i = 0;
        while ((rawData.num2.length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (rawData.num2.startsWith(symbol.name())) {
                newData.num2 += symbol.getValue();
                rawData.num2 = rawData.num2.substring(symbol.name().length());
            } else {
                i++;
            }
        }
        if (rawData.num1.length() > 0) {
            throw new IllegalArgumentException(rawData.num1 + " cannot be converted to a Roman Numeral");
        }
        if (rawData.num2.length() > 0) {
            throw new IllegalArgumentException(rawData.num2 + " cannot be converted to a Roman Numeral");
        }
        return newData;
    }

    public static String arabicToRoman(int number) {

        List<RomanNumeral> romanNumerals = RomanNumeral.getValues();

        if (number < 1) {
            throw new NumberFormatException("The result of calculating Roman operands can only be a positive number");
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (i < romanNumerals.size()) {
            RomanNumeral Symbol = romanNumerals.get(i);
            if (Symbol.getValue() <= number) {
                sb.append(Symbol.name());
                number -= Symbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static FinData parsing(RawData rawData) {

        FinData newData;

        try {
            newData = new FinData(Integer.parseInt(rawData.num1), Integer.parseInt(rawData.num2), false);
        } catch (NumberFormatException e) {
            newData = romanToArabic(rawData);
        }
        return newData;
    }
}
