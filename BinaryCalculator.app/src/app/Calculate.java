package app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Calculate implements CalculateOptions {

    public long calculateBinaryToDecimal(long number) {
        int[] digits = getDigits(number);

        double result = 0;
        int n = digits.length - 1;
        for (int i = 0; i < digits.length; i++) {

            result += digits[i] * Math.pow(2, n);
            n = n - 1;
        }

        return (long) result;
    }


    public long calculateDecimalToBinary(long number) {
        List<Integer> binary = new ArrayList<>();

        while (number != 0) {
            int calc = (int) number % 2;
            binary.add(binary.size(), calc);
            number = (int) number / 2;

        }
        String result = binary.stream().map(Object::toString).collect(Collectors.joining(""));
        System.out.println(result);


        return Long.parseLong(result);
    }

    @Override
    public String calculateHexadecimalToDecimal(String number) {

        int result = 0;
        int n = number.length() - 1;
        for (int i = 0; i < number.length(); i++) {
            char currentChar = number.charAt(i);
            int currentDigit = 0;
            if (!Character.isDigit(currentChar)) {
                switch (currentChar) {
                    case 'A':
                        currentDigit = HexLetters.A.getValue();
                        break;
                    case 'B':
                        currentDigit = HexLetters.B.getValue();
                        break;
                    case 'C':
                        currentDigit = HexLetters.C.getValue();
                        break;
                    case 'D':
                        currentDigit = HexLetters.D.getValue();
                        break;
                    case 'E':
                        currentDigit = HexLetters.E.getValue();
                        break;
                    case 'F':
                        currentDigit = HexLetters.F.getValue();

                }

                result += currentDigit * Math.pow(16, n);

            } else {
                currentDigit = Character.getNumericValue(number.charAt(i));
                result += currentDigit * Math.pow(16, n);
            }
            n--;
        }


        return String.valueOf(result);
    }

    private int[] getDigits(long number) {
        StringBuilder digit = new StringBuilder();
        digit.append(number);
        int[] digits = new int[digit.length()];
        for (int i = 0; i < digit.length(); i++) {

            digits[i] = Integer.parseInt(String.valueOf(digit.charAt(i)));
        }
        return digits;
    }
}
