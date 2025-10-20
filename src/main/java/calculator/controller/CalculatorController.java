package calculator.controller;

import calculator.model.StringCalculator;
import calculator.view.CalculatorView;

public class CalculatorController {
    private final StringCalculator model;
    private final CalculatorView view;

    public CalculatorController(StringCalculator model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.displayInputPrompt();

        String input = view.getInput();
    }
}
