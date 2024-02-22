package calculator.impl;

import calculator.numbers.ComplexNumber;

public interface Calculable {
    ComplexNumber add (ComplexNumber number1, ComplexNumber number);
    ComplexNumber multiply (ComplexNumber number1, ComplexNumber number);
    ComplexNumber divide (ComplexNumber number1, ComplexNumber number);
}
