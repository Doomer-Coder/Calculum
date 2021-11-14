package maths;

import standard.Fields;

public class Discriminant extends Fields {
    private static double discriminant;

    public static String main(String strA, String strB, String strC) {
        double realA;
        double realB;
        double realC;
        String answer = "";

        try {
            realA = Double.parseDouble(strA.replace(',', '.'));
            realB = Double.parseDouble(strB.replace(',', '.'));
            realC = Double.parseDouble(strC.replace(',', '.'));
        } catch (NumberFormatException e) {
            answer = error();
            return answer;
        }

        discriminant = realB * realB - 4 * realA * realC;
        answer += answerBuilder(realA, realB, realC);

        if (discriminant > 0) {
            answer += discriminantIsPositive(realA, realB);
        } else if (discriminant == 0) {
            answer += discriminantIsZero(realA, realB);
        } else {
            answer += discriminantIsNegative();
        }
        return answer;
    }

    protected static String answerBuilder(double realA, double realB, double realC) {
        String functionResult = "ax² + bx + c = 0\n";
        functionResult += toInteger(realA) + "x² + " + toInteger(realB) + "x + " + toInteger(realC) + " = 0\n";
        functionResult += "D = b² - 4ac\n";
        functionResult += "D = " + toInteger(realB) + "² - 4 * " + toInteger(realA) + " * " + toInteger(realC) + " = ";
        functionResult += toInteger(realB * realB) + " - " + toInteger(4 * realA * realC) + " = ";
        functionResult += toInteger(discriminant) + "\n\n";
        return functionResult;
    }

    protected static String discriminantIsPositive(double realA, double realB) {
        String functionResult = "Так как дискриминант больше нуля =>\n";
        functionResult += "Данное квадратное уравнение имеет два вещественных корня.\n";
        double radixFromD = Math.sqrt(discriminant);
        double x1 = (-realB + radixFromD) / (2 * realA);
        double x2 = (-realB - radixFromD) / (2 * realA);
        return functionResult;
    }

    protected static String discriminantIsZero(double realA, double realB) {
        String outcome = "";
        String functionResult = "Так как дискриминант равен нулю =>\n";
        functionResult += "Данное квадратное уравнение имеет один вещественный корень.\n";
        double x = -realB / (2 * realA);
        functionResult += "x = -b / (2a)\n";
        functionResult += "x = " + toInteger(-realB) + " / (2 * " + toInteger(realA) + ") = ";
        functionResult += toInteger(-realB) + " / " + toInteger(2 * realA) + " = ";
        functionResult += toInteger(reduction(-realB, 2 * realA)[0]) + " / ";
        functionResult += toInteger(reduction(-realB, 2 * realA)[1]) + " = ";
        if (isPeriodic(-realB / 2 * realA)) {
            outcome += toInteger(reduction(-realB, 2 * realA)[0]) + " / ";
            outcome += toInteger(reduction(-realB, 2 * realA)[1]) + " = ";
        } else {
            functionResult += toInteger(-realB / (2 * realA)) + "\n\n";
            outcome += toInteger(-realB / (2 * realA));
        }
        functionResult += "Ответ: x = " + outcome + ".";
        return functionResult;
    }

    protected static String discriminantIsNegative() {
        String functionResult = "Так как дискриминант меньше нуля =>\n";
        functionResult += "Данное квадратное уравнение не имеет вещественных корней.\n\n";
        functionResult += "Ответ: Вещественных корней нет.";
        return functionResult;
    }

    protected static String toInteger(double doubleNum) {
        long longNum = (long) doubleNum;
        return (doubleNum == longNum) ? String.valueOf(longNum) : String.valueOf(doubleNum);
    }

    protected static boolean isPeriodic(double doubleNum) {
        return true;
    }

    private static double[] reduction(double thisNumerator, double thisDenominator) {
        double divider;
        double numerator = thisNumerator;
        double denominator = thisDenominator;
        while (thisNumerator != 0 && thisDenominator != 0) {
            if (thisNumerator > thisDenominator) {
                thisNumerator = thisNumerator % thisDenominator;
            } else {
                thisDenominator = thisDenominator % thisNumerator;
            }
        }
        divider = Math.abs(thisNumerator + thisDenominator);
        return new double[] { numerator / divider, denominator / divider };
    }
}