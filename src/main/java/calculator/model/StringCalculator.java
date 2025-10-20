package calculator.model;

import java.util.regex.Pattern;

public class StringCalculator {
    public int calculate(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:"; // 기본 구분자
        String number = text;

        if (text.startsWith("//")) { // 커스텀 구분자
            int customDelimiterIndex = text.indexOf("\\n");

            if (customDelimiterIndex == -1) {
                throw new IllegalArgumentException("커스텀 구분자 지정이 잘못되었습니다.");
            }

            String customDelimiter = text.substring(2, customDelimiterIndex);

            if (customDelimiter.isEmpty() || customDelimiter.contains("//") || customDelimiter.contains("\\n")) {
                throw new IllegalArgumentException("공백, //, \\n은 커스텀 구분자로 사용할 수 없습니다.");
            }

            delimiter = customDelimiter;
            number = text.substring(customDelimiterIndex + 2);
        }

        return sumNumber(splitNumber(delimiter, number));
    }

    private String[] splitNumber(String delimiter, String number) {
        if (delimiter.equals(",|:")) {
            return number.split(delimiter);
        }

        return number.split(Pattern.quote(delimiter));
    }

    private int sumNumber(String[] numbers) {
        int total = 0;

        for (String numberStr : numbers) {
            if (numberStr.isEmpty()) {
                continue;
            }

            try {
                int number = Integer.parseInt(numberStr);

                if (number < 0) {
                    throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
                }

                total += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("구분자와 양수만 입력 가능합니다.");
            }
        }
        return total;
    }
}
