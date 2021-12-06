package calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static calc.Calculate.calculate;
import static calc.Parsing.parsing;
import static calc.Parsing.arabicToRoman;

public class MainClass {

    public static void printResult(int result, boolean isRome) {
        if (isRome) {
            System.out.println(arabicToRoman(result));
        } else {
            System.out.println(result);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        RawData rawData = new RawData(null, null);
        FinData finData;
        String line;
        String operator;

        System.out.println("Enter the expression <a + b> or <a - b> or <a * b> or <a / b>. Where <a> and <b> " +
                "can be equal 1-10 Arabic or I-X Rome numbers");
        while (!(line = reader.readLine()).equals("exit")) {
            Scanner scanner = new Scanner(line);
            if (line.split(" ").length != 3) {
                throw new IllegalArgumentException("Please enter the expression like this: a + b");
            }
            rawData.num1 = scanner.next();
            operator = scanner.next();
            rawData.num2 = scanner.next();
            finData = parsing(rawData);
            printResult(calculate(finData, operator), finData.isRome);
        }
    }
}
