package calculator.model;

import java.util.Arrays;

public class StringCalculator {
    public int calculate(String text) {
        String delimiter = ",|:";
        String number = text;

        if (text.startsWith("//")) {
            int customDelimiterIndex = text.indexOf("\\n");

            if (customDelimiterIndex == -1) {
                // 예외 처리
            }

            String customDelimiter = text.substring(2, customDelimiterIndex);

            delimiter = customDelimiter;
            number = text.substring(customDelimiterIndex + 2);
        }

        return 0; // 임시 return
    }

    private String[] splitNumber(String delimiter, String number) {
        if (delimiter.equals(",|:")) {
            return number.split(delimiter);
        }

        String safeDelimiter = ",";
        String replaceText = number.replace(delimiter, safeDelimiter);
        return replaceText.split(safeDelimiter);
    }
}
