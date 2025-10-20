package calculator.model;

public class StringCalculator {
    public int calculate(String text) {
        String delimiter = ",|:";
        String number = text;

        return 0; // 임시 return
    }

    private String[] splitNumber(String delimiter, String number) {
        return number.split(delimiter);
    }
}
