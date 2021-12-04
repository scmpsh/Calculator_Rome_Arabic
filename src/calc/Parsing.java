package calc;

import static calc.Calculate.calculate;

public class Parsing {

    public static int[] myGetRome(String[] arr) {
        int[] res;
        res = null;
        enum Numeral {
            I("I", 1), IV("IV", 4), V("V", 5), IX("IX", 9),
            X("X", 10), XL("XL", 40), L("L", 50), XC("XC", 90),
            C("C", 100);
            final String key;
            final int value;

            Numeral(String key, int value) {
                this.key = key;
                this.value = value;
            }
        }
        return (res);
    }

    public static int[] myGetInt(String[] arr) {
        int[] ret = new int[3];

        try {
            ret[0] = Integer.parseInt(arr[0]);
            ret[2] = Integer.parseInt(arr[2]);
            if (ret[0] < 1 || ret[0] > 10) {
                throw new IllegalArgumentException();
            } else {
                return ret;
            }
        } catch (NumberFormatException e) {
            System.err.println("It's not integer");
            return (null);
        } catch (IllegalArgumentException e) {
            System.err.println("Numbers 1-10 range and positive");
            return (null);
        }
    }

    public static int parsing(String[] arr) {
        boolean rome;
        int[] ret;
        String operation;
        try {
            if (!(arr[1].equals("+")) && !(arr[1].equals("-"))
                    && !(arr[1].equals("*")) && !(arr[1].equals("/"))) {
                throw new AssertionError();
            }
        } catch (AssertionError e) {
            System.err.println("Wrong operation");
            return 1;
        }
        try {
            ret = myGetInt(arr);
            rome = false;
            if (ret == null)
                return (1);
        } catch (NumberFormatException e) {
            ret = myGetRome(arr);
            if (ret == null)
                return 1;
            rome = true;
        }
        if (!rome) {
            operation = arr[1];
            calculate(ret, operation);
        } else {
            return 0;
        }
        return 0;
    }
}
