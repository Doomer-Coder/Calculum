package Informatics;

public class Notation {
    private static final String ALPHABET = alphabetBuilder();
    public static String main(String value, String strBase, String newStrBase) {
        int base;
        int newBase;
        String answer;

        try {
            base = Integer.parseInt(strBase);
            newBase = Integer.parseInt(newStrBase);
        } catch (NumberFormatException e) {
            answer = error();
            return answer;
        }

        try {
            answer = interpretation(value, base, newBase);
        } catch (NumberFormatException e) {
            answer = exception(base, newBase);
        }

        return answer;
    }

    private static String interpretation(String value, int base, int newBase) {
        String functionResult = "";

        if (base == newBase) {
            functionResult = value;
            return functionResult;
        }

        long decimal = Long.parseLong(value, base);

        if (newBase == 10) {
            functionResult = String.valueOf(decimal);
            return functionResult;
        }
        while (decimal != 0) {
            String digit = Long.toString(decimal - decimal / newBase * newBase);
            if (Integer.parseInt(digit) >= 10) {
                digit = Character.toString(ALPHABET.charAt(Integer.parseInt(digit) - 10));
            }
            functionResult = digit.concat(functionResult);
            decimal /= newBase;
        }
        return functionResult;
    }
    private static String exception(int base, int newBase) {
        String functionResult;
        String rangeOfNumbers;
        String rangeOfLetters = "";

        if (base <= 1 || 37 <= base || newBase <= 1 || 37 <= newBase) {
            functionResult = error();
            return functionResult;
        }

        functionResult = "Число в указанной (" + base + "-ичной) системе счисления может содержать: ";

        if (base <= 10) {
            rangeOfNumbers = "только цифры от 0 до " + (base - 1);
        } else if (base == 11) {
            rangeOfNumbers = "только цифры от 0 до 9";
            rangeOfLetters = ", а также букву A";
        } else {
            rangeOfNumbers = "только цифры от 0 до 9";
            rangeOfLetters = ", а также буквы от A до " + ALPHABET.charAt(base - 11);
        }

        functionResult += rangeOfNumbers + rangeOfLetters + '.';

        return functionResult;
    }
    private static String error() {
        return "Пожалуйста, введите корректное основание системы счисления.";
    }
    private static String alphabetBuilder() {
        String functionResult = "";
        for (char i = 'A'; i <= 'Z'; i++) {
            functionResult = functionResult.concat(String.valueOf(i));
        }
        return functionResult;
    }
}