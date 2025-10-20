package calculator;

import calculator.controller.CalculatorController;
import calculator.model.StringCalculator;
import calculator.view.CalculatorView;

public class Application {
    public static void main(String[] args) {
        StringCalculator model = new StringCalculator();
        CalculatorView view = new CalculatorView();
        CalculatorController controller = new CalculatorController(model, view);

        controller.run();
    }
}
