package calculator.model;

public class StringCalculator {
    public int calculate(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

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

        return sumNumber(splitNumber(delimiter, number));
    }

    private String[] splitNumber(String delimiter, String number) {
        if (delimiter.equals(",|:")) {
            return number.split(delimiter);
        }

        String safeDelimiter = ",";
        String replaceText = number.replace(delimiter, safeDelimiter);
        return replaceText.split(safeDelimiter);
    }

    private int sumNumber(String[] numbers) {
        int total = 0;

        for (String numberStr : numbers) {
            if (numberStr.isEmpty()) {
                continue;
            }
            int number = Integer.parseInt(numberStr);
            total += number;

            // parseInt 예외처리 필요
        }

        return total;
    }
}
