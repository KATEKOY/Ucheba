package Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число 'a' с плавающей запятой");
        Double a = scanner.nextDouble();
        System.out.println("Введите число 'b' с плавающей запятой");
        Double b = scanner.nextDouble();
        Calculator calculator = new Calculator(new Adder());
        calculator.calc(a, b);
        calculator = new Calculator(new Subtractor());
        calculator.calc(a, b);
        calculator = new Calculator(new Divider());
        calculator.calc(a, b);
        calculator = new Calculator(new Multiplier());
        calculator.calc(a, b);



    }
}