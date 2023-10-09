package my.calculator;
public class Calculator {
    public double add(double num1, double num2) {
        return num1 + num2;
    }
//hkhwkfhwkfkj
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return num1 / num2;
    }

    public double sqrt(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate the square root of a negative number!");
        }
        return Math.sqrt(num);
    }

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}