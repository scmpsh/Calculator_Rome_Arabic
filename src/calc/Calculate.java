package calc;

public class Calculate {
    public static int calculate(int[] arr, String operation, int isRome) {
        try {
            if (arr[0] < 1 || arr[0] > 10 || arr[1] < 1 || arr[1] > 10) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Numbers must be in 1-10 or I-X range");
            return 1;
        }
        if (isRome == 0) {
            switch (operation) {
                case ("+") -> System.out.println(arr[0] + arr[1]);
                case ("-") -> System.out.println(arr[0] - arr[1]);
                case ("*") -> System.out.println(arr[0] * arr[1]);
                case ("/") -> System.out.println(arr[0] / arr[1]);
                default -> System.err.println("Unexpected operation: " + operation);
            }
            return 0;
        } else {
            return 1;
        }
    }
}
