package calculator.numbers;


public class ComplexNumberParser {
    public ComplexNumber parse(String input) {
        ComplexNumber complexNumber = new ComplexNumber(0, 0);
        double imaginary;
        String[] parts = input.trim().split("[+\\-/*]");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Некорректный ввод!");
        }
        double real = parts[0].isEmpty() ? 0 : Double.parseDouble(parts[0].trim());
        char operator = input.charAt(parts[0].length());
        int degree = parts[1].contains("^") ? Integer.parseInt(parts[1].trim().split("\\^")[1]) % 4 : 1;
        if (parts[1].contains("^")) {
            if (parts[1].trim().split("\\^")[0]
                    .substring(0, parts[1].trim().split("\\^")[0].length() - 1).isEmpty()) {
                imaginary = 1;
            } else {
                imaginary = Double.parseDouble(parts[1].trim().split("\\^")[0]
                        .substring(0, parts[1].trim().split("\\^")[0].length() - 1));
            }
        } else {
            imaginary = Double.parseDouble(parts[1].substring(0, parts[1].length() - 1));
        }

        return switch (operator) {
            case '+' -> parseAdd(real, imaginary, degree);
            case '-' -> parseSubstract(real, imaginary, degree);
            case '*' -> parseMultiply(real, imaginary, degree);
            case '/' -> parseDivide(real, imaginary, degree);
            default -> throw new IllegalArgumentException("Некорректный ввод!");
        };
    }

    private ComplexNumber parseAdd(double real, double imaginary, int degree){
        switch (degree){
            case 1:
                break;
            case 2:
                real -= imaginary;
                imaginary = 0;
                break;
            case 3:
                imaginary = -imaginary;
                break;
            case 0:
                real += imaginary;
                imaginary = 0;
                break;
            default:
                throw new IllegalArgumentException("Некорректный ввод!");
        }
        return new ComplexNumber(real, imaginary);
    }

    private ComplexNumber parseSubstract(double real, double imaginary, int degree){
        switch (degree){
            case 1:
                imaginary = -imaginary;
                break;
            case 2:
                real += imaginary;
                imaginary = 0;
                break;
            case 3:
                break;
            case 0:
                real -= imaginary;
                imaginary = 0;
                break;
            default:
                throw new IllegalArgumentException("Некорректный ввод!");
        }
        return new ComplexNumber(real, imaginary);
    }

    private ComplexNumber parseMultiply(double real, double imaginary, int degree){
        switch (degree){
            case 1:
                imaginary = real * imaginary;
                real = 0;
            case 2:
                real = -(real * imaginary);
                imaginary = 0;
                break;
            case 3:
                imaginary = -(real * imaginary);
                real = 0;
                break;
            case 0:
                real *= imaginary;
                imaginary = 0;
                break;
            default:
                throw new IllegalArgumentException("Некорректный ввод!");
        }
        return new ComplexNumber(real, imaginary);
    }

    private ComplexNumber parseDivide (double real, double imaginary, int degree){
        switch (degree){
            case 1:
                imaginary = real / imaginary;
                real = 0;
                break;
            case 2:
                real = -(real / imaginary);
                imaginary = 0;
                break;
            case 3:
                imaginary = -(real / imaginary);
                real = 0;
                break;
            case 0:
                real /= imaginary;
                imaginary = 0;
                break;
            default:
                throw new IllegalArgumentException("Некорректный ввод!");
        }
        return new ComplexNumber(real, imaginary);
    }
}

