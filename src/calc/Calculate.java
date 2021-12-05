package calc;

import static calc.Parsing.arabicToRoman;

public class Calculate {
    public static void calculate(int[] arr, String operation, int isRome) {

        if (arr[0] < 1 || arr[0] > 10 || arr[1] < 1 || arr[1] > 10) {
            throw new IllegalArgumentException("Numbers must be equal 1-10 Arabic or I-X Rome numbers");
        }
        if (isRome == 0) {
            switch (operation) {
                case ("+") -> System.out.println(arr[0] + arr[1]);
                case ("-") -> System.out.println(arr[0] - arr[1]);
                case ("*") -> System.out.println(arr[0] * arr[1]);
                case ("/") -> System.out.println(arr[0] / arr[1]);
                default -> throw new IllegalStateException("Unexpected value: " + operation);
            }
        } else if (isRome == 2) {
            switch (operation) {
                case ("+") -> System.out.println(arabicToRoman(arr[0] + arr[1]));
                case ("-") -> System.out.println(arabicToRoman(arr[0] - arr[1]));
                case ("*") -> System.out.println(arabicToRoman(arr[0] * arr[1]));
                case ("/") -> System.out.println(arabicToRoman(arr[0] / arr[1]));
                default -> throw new IllegalStateException("Unexpected value: " + operation);
            }
        }
    }
}
