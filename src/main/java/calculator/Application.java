package calculator;

import calculator.controller.CalculatorController;
import calculator.model.StringCalculator;
import calculator.view.CalculatorView;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            StringCalculator model = new StringCalculator();
            CalculatorView view = new CalculatorView();
            CalculatorController controller = new CalculatorController(model, view);

            controller.run();
        } finally {
            Console.close();
        }
    }
}
