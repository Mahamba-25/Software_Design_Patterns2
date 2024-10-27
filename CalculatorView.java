import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Отвечает за интерфейс пользователя.
 * Содержит поля для ввода чисел, кнопки для операций и область для вывода результата.
 */
public class CalculatorView extends JFrame {
    private JTextField firstNumber = new JTextField(15);
    private JTextField secondNumber = new JTextField(15);
    private JButton addButton = new JButton("+");
    private JButton subtractButton = new JButton("-");
    private JButton multiplyButton = new JButton("*");
    private JButton divideButton = new JButton("/");
    private JButton powerButton = new JButton("^");
    private JButton clearButton = new JButton("Очистить");
    private JButton exitButton = new JButton("Выйти");
    private JLabel resultLabel = new JLabel("Результат: ");

    public CalculatorView() {
        Font font = new Font("Arial", Font.PLAIN, 18);
        firstNumber.setFont(font);
        secondNumber.setFont(font);
        resultLabel.setFont(font);

        addButton.setFont(font);
        subtractButton.setFont(font);
        multiplyButton.setFont(font);
        divideButton.setFont(font);
        powerButton.setFont(font);
        clearButton.setFont(font);
        exitButton.setFont(font);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 15, 15));

        panel.add(new JLabel("Первое число: "));
        panel.add(firstNumber);

        panel.add(new JLabel("Второе число: "));
        panel.add(secondNumber);

        panel.add(resultLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);
        buttonPanel.add(powerButton);

        JPanel controlPanel = new JPanel();
        controlPanel.add(clearButton);
        controlPanel.add(exitButton);

        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.CENTER);
        this.add(controlPanel, BorderLayout.SOUTH);

        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public double getFirstNumber() throws NumberFormatException {
        return Double.parseDouble(firstNumber.getText());
    }

    public double getSecondNumber() throws NumberFormatException {
        return Double.parseDouble(secondNumber.getText());
    }

    public void setResult(String result) {
        resultLabel.setText("Результат: " + result);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
    }

    public void clearFields() {
        firstNumber.setText("");
        secondNumber.setText("");
        resultLabel.setText("Результат: ");
    }

    public void addOperationListener(ActionListener listener) {
        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        multiplyButton.addActionListener(listener);
        divideButton.addActionListener(listener);
        powerButton.addActionListener(listener);
        clearButton.addActionListener(listener);
        exitButton.addActionListener(listener);
    }

    public JButton getAddButton() { return addButton; }
    public JButton getSubtractButton() { return subtractButton; }
    public JButton getMultiplyButton() { return multiplyButton; }
    public JButton getDivideButton() { return divideButton; }
    public JButton getPowerButton() { return powerButton; }
    public JButton getClearButton() { return clearButton; }
    public JButton getExitButton() { return exitButton; }
}
