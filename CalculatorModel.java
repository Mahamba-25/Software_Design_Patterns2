/**
 * Хранит и выполняет логику вычислений
 */
public class CalculatorModel {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Ошибка: деление на ноль");
        }
        return a / b;
    }

   /* public double factorial(int a) {
        if (a == 0) {
            return 1;
        }
        return a * factorial(a - 1);
    }*/

    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}