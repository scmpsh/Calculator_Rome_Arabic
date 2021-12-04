package calc;

import static calc.Calculate.calculate;

public class Parsing {

    public static int[] myGetRome(String[] arr) {
        int[] res = new int[3];
        enum romanNumeral {
            I("I", 1), IV("IV", 4), V("V", 5), IX("IX", 9),
            X("X", 10), XL("XL", 40), L("L", 50), XC("XC", 90),
            C("C", 100);
            final String key;
            final int value;

            romanNumeral(String key, int value) {
                this.key = key;
                this.value = value;
            }

            public int getValue() {
                return value;
            }

            public String getKey() {
                return key;
            }
        }
        for (romanNumeral romanNum : romanNumeral.values()) {
            if (arr[0].equals(romanNum.getKey())) {
                res[0] = romanNum.getValue();
                System.out.println(res[0]);
            }
        }
        return (res);
    }

    public static int parsing(String[] arr) {
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
        try {
            if (isStr == 2) {
                ret = myGetRome(arr);
                return 1;
            } else if (isStr == 0) {
                calculate(ret, operation, isStr);
                return 0;
            } else if (isStr == 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            System.err.println("Two numbers must be Roman or Arabic at the same time");
            return 1;
        }
        return 0;
    }
}
