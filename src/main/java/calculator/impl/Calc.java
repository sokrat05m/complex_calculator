package calculator.impl;

import calculator.impl.Calculable;
import calculator.numbers.ComplexNumber;

public class Calc implements Calculable {

    @Override
    public ComplexNumber add(ComplexNumber number1, ComplexNumber number2) {
        double resultReal = number1.getReal() + number2.getReal();
        double resultImaginary = number1.getImaginary() + number2.getImaginary();
        System.out.println("Суммирую " + number1 + " и " + number2);
        return new ComplexNumber(resultReal, resultImaginary);
    }

    @Override
    public ComplexNumber multiply(ComplexNumber number1, ComplexNumber number2) {
        double realResult = number1.getReal() * number2.getReal() - number1.getImaginary() * number2.getImaginary();
        double imaginaryResult = number1.getReal() * number2.getImaginary() + number1.getImaginary() * number2.getReal();
        System.out.printf("Умножаю " + number1 + " на " + number2);
        return new ComplexNumber(realResult, imaginaryResult);
    }

    @Override
    public ComplexNumber divide(ComplexNumber number1, ComplexNumber number2) {
        double denominator = number2.getReal() * number2.getReal() + number2.getImaginary() * number2.getImaginary();
        double realResult = (number1.getReal() * number2.getReal() + number1.getImaginary() * number2.getImaginary()) / denominator;
        double imaginaryResult = (number1.getImaginary() * number2.getReal() - number1.getReal() * number2.getImaginary()) / denominator;
        System.out.printf("Делю " + number1 + " на " + number2);
        return new ComplexNumber(realResult, imaginaryResult);
    }
}
