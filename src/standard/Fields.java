package standard;

public class Fields {
    protected static String alphabetBuilder(char begin, char end) {
        String functionResult = "";
        for (char i = begin; i <= end; i++) {
            functionResult = functionResult.concat(String.valueOf(i));
        }
        return functionResult;
    }
    protected static String interpretationError() {
        return "Пожалуйста, введите число.";
    }
}
