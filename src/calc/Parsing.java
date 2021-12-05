package calc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static calc.Calculate.calculate;

public class Parsing {

    enum RomanNumeral {
        C(100), XC(90), L(50), XL(40), X(10),
        IX(9), V(5), IV(4), I(1);

        final int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static List<RomanNumeral> getValues() {
            return Arrays.stream(values()).collect(Collectors.toList());
        }
    }

    public static int[] romanToArabic(String[] arr) {
        int[] ret = new int[2];

        List<RomanNumeral> romanNumerals = RomanNumeral.getValues();

        int i = 0;

        while ((arr[0].length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (arr[0].startsWith(symbol.name())) {
                ret[0] += symbol.getValue();
                arr[0] = arr[0].substring(symbol.name().length());
            } else {
                i++;
            }
        }
        i = 0;
        while ((arr[2].length() > 0) && (i < romanNumerals.size())) {
            RomanNumeral symbol = romanNumerals.get(i);
            if (arr[2].startsWith(symbol.name())) {
                ret[1] += symbol.getValue();
                arr[2] = arr[2].substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (arr[0].length() > 0) {
            throw new IllegalArgumentException(arr[0] + " cannot be converted to a Roman Numeral");
        }
        if (arr[2].length() > 0) {
            throw new IllegalArgumentException(arr[2] + " cannot be converted to a Roman Numeral");
        }
        return ret;
    }

    public static String arabicToRoman(int number) {
        List<RomanNumeral> romanNumerals = RomanNumeral.getValues();

        if (number <= 0) {
            throw new NumberFormatException("The result of calculating Roman numbers can only be a positive number");
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

    public static void parsing(String[] arr) {
        int isStr;
        int[] ret = new int[2];
        String operation;

        isStr = 0;
        operation = arr[1];
        try {
            ret[0] = Integer.parseInt(arr[0]);
        } catch (NumberFormatException e) {
            ++isStr;
        }
        try {
            ret[1] = Integer.parseInt(arr[2]);
        } catch (NumberFormatException e) {
            ++isStr;
        }
        if (isStr == 2) {
            ret = romanToArabic(arr);
            calculate(ret, operation, isStr);
        } else if (isStr == 0) {
            calculate(ret, operation, isStr);
        } else {
            throw new NumberFormatException("The expression must contain only Roman or Arabic numbers");
        }
    }
}
