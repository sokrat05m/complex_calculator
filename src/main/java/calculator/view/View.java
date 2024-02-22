package calculator.view;

import calculator.impl.Calc;
import calculator.numbers.ComplexNumber;
import calculator.numbers.ComplexNumberParser;

import java.util.Scanner;

public class View {
    ComplexNumberParser parser = new ComplexNumberParser();
    Calc calc = new Calc();
    public void run() {
        String input1 = prompt("Введите первое комплексное число: ");
        String operation = prompt("Введите команду (+, *, /): ");
        String input2 = prompt("Введите второе комплексное число: ");
        switch (operation) {
            case "+":
                ComplexNumber result = calc.add(parser.parse(input1), parser.parse(input2));
                System.out.println("Ответ: " + result);
                break;
            case "*":
                result = calc.multiply(parser.parse(input1), parser.parse(input2));
                System.out.println("Ответ: " + result);
                break;
            case "/":
                result = calc.divide(parser.parse(input1), parser.parse(input2));
                System.out.println("Ответ: " + result);
                break;
            default:
                throw new IllegalArgumentException("Некорректный ввод!");
        }
    }


    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}