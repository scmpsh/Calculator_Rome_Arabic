package calc;

public class Calculate {
    public static int calculate(FinData finData, String operator) {

        if (finData.num1 < 1 || finData.num1 > 10 || finData.num2 < 1 || finData.num2 > 10) {
            throw new IllegalArgumentException("Numbers must be equal 1-10 Arabic or I-X Rome numbers");
        }
        return switch (operator) {
            case ("+") -> finData.num1 + finData.num2;
            case ("-") -> finData.num1 - finData.num2;
            case ("*") -> finData.num1 * finData.num2;
            case ("/") -> finData.num1 / finData.num2;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }
}
