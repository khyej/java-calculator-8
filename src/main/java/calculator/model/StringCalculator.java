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
                throw new IllegalArgumentException();
            }

            String customDelimiter = text.substring(2, customDelimiterIndex);

            if (customDelimiter.isEmpty() || customDelimiter.contains("\\n") || customDelimiter.contains("//")) {
                throw new IllegalArgumentException();
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

            try {
                int number = Integer.parseInt(numberStr);

                if (number < 0) {
                    throw new IllegalArgumentException();
                }

                total += number;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
        return total;
    }
}
