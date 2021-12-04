package calc;

public class Calculate {
    public static void calculate(int[] arr, String operation) {
        switch (operation) {
            case ("+") -> System.out.printf("%d + %d = %d\n", arr[0], arr[2], arr[0] + arr[2]);
            case ("-") -> System.out.printf("%d - %d = %d\n", arr[0], arr[2], arr[0] - arr[2]);
            case ("*") -> System.out.printf("%d * %d = %d\n", arr[0], arr[2], arr[0] * arr[2]);
            case ("/") -> System.out.printf("%d / %d = %d\n", arr[0], arr[2], arr[0] / arr[2]);
            default -> {
            }
        }
    }
}
