/**
 * Инициализирует модель, представление и контроллер.
 * Запускает приложение.
 */
public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        new CalculatorController(model, view);
    }
}
