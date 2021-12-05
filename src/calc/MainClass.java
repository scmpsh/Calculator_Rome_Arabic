package calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static calc.Parsing.parsing;

public class MainClass {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] arr = new String[3];
        System.out.println("Enter the expression <a + b> or <a - b> or <a * b> or <a / b>. Where <a> and <b> " +
                "can be equal 1-10 Arabic or I-X Rome numbers");
        while (!(line = reader.readLine()).equals("exit")) {
            Scanner scanner = new Scanner(line);
            if (line.split(" ").length != 3) {
                throw new IllegalArgumentException("Please enter the expression like this: a + b");
            }
            for (int i = 0; i < 3; i++)
                arr[i] = scanner.next();
            parsing(arr);
        }
    }
}
