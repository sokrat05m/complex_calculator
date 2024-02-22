package calculator.numbers;

public class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public String toString() {
        if (imaginary < 0) {
            return String.format("%.2f - %.2fi", real, Math.abs(imaginary));
        }
        if (imaginary > 0){
            return String.format("%.2f + %.2fi", real, imaginary);
        }
        if (imaginary == 0){
            return Double.toString(real);
        }
        return null;
    }
}
