package standard;

public class Fields {
    protected static final String ALPHABET = alphabetBuilder();

    protected static String alphabetBuilder() {
        String functionResult = "";
        for (char i = 'A'; i <= 'Z'; i++) {
            functionResult = functionResult.concat(String.valueOf(i));
        }
        return functionResult;
    }
    protected static String error() {
        return "Пожалуйста, введите число.";
    }
}
