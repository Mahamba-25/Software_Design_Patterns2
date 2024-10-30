import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Принимает события от View и вызывает соответствующие методы модели.
 * Обновляет View с результатами вычислений или сообщает об ошибках.
 */
public class CalculatorController {
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;

        view.addOperationListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleOperation(e);
            }
        });
    }

    private void handleOperation(ActionEvent e) {
        if (e.getSource() == view.getClearButton()) {
            view.clearFields();
            return;
        }
        else if (e.getSource() == view.getExitButton()) {
            System.exit(0);
            return;
        }
        else {
            try {
                double firstNumber = view.getFirstNumber();
                double secondNumber = view.getSecondNumber();
                double result;

                if (e.getSource() == view.getAddButton()) {
                    result = model.add(firstNumber, secondNumber);
                } else if (e.getSource() == view.getSubtractButton()) {
                    result = model.subtract(firstNumber, secondNumber);
                } else if (e.getSource() == view.getMultiplyButton()) {
                    result = model.multiply(firstNumber, secondNumber);
                } else if (e.getSource() == view.getDivideButton()) {
                    result = model.divide(firstNumber, secondNumber);
                } else if (e.getSource() == view.getPowerButton()) {
                    result = model.power(firstNumber, secondNumber);
                } /*else if (e.getSource() == view.getExclamationButton) {
                result = model.factorial(firstNumber);
            }*/ else {
                    throw new UnsupportedOperationException("Неизвестная операция");
                }

                view.setResult(String.valueOf(result));
            } catch (NumberFormatException ex) {
                view.showError("Введите корректные числа.");
            } catch (ArithmeticException ex) {
                view.showError(ex.getMessage());
            }
        }
    }
}
