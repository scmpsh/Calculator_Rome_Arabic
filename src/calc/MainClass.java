package calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static calc.Parsing.parsing;

public class MainClass {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String[] arr = new String[3];
        System.out.println("Enter the expression <a + b> or <a - b> or <a * b> or <a / b>. Where <a> and <b> " +
                "can be equal 0-10 arabic or I-X rome numbers");
        while (!(line = reader.readLine()).equals("exit")) {
            Scanner scanner = new Scanner(line);
            try {
                for (int i = 0; i < 3; i++)
                    arr[i] = scanner.next();
            } catch (NoSuchElementException e) {
                System.err.println("Please enter the expression like this: a + b");
                continue ;
            }
            parsing(arr);
        }
    }
}
