package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorView {
    public void displayInputPrompt() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public String getInput() {
        return Console.readLine();
    }
}
