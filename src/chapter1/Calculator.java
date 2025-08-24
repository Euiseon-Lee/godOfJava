package chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    public static void main(String[] args) throws IOException {
        System.out.println("calculator class started.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numA = Integer.parseInt(br.readLine());
        int numB = Integer.parseInt(br.readLine());
        Calculator obj = new Calculator();
        System.out.println("numA + numB = " + obj.add(numA, numB));
    }
    public int add(int a, int b) {
        return a + b;
    }
    public int subtract(int a, int b) {
        return a - b;
    }
    public int multiply(int a, int b) {
        return a * b;
    }
    public int devide(int a, int b) {
        return a / b;
    }
}
