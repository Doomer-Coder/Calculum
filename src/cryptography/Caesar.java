package cryptography;

import standard.*;

import java.util.Locale;

public class Caesar extends Fields {
    public static String code(String data, String ... strKey) {
        int key;
        String answer;
        StringBuilder arrayAnswer = new StringBuilder();
        try {
            key = Integer.parseInt(String.join(" ", strKey));
        } catch (NumberFormatException e) {
            arrayAnswer.append(interpretationError());
            answer = String.join("", arrayAnswer);
            return answer;
        }
        int newIndex;
        for (char letter: data.toCharArray()) {
            if (ALPHABET.contains(String.valueOf(letter))) {
                newIndex = (ALPHABET.indexOf(letter) + key) % ALPHABET.length();
                arrayAnswer.append(ALPHABET.charAt(newIndex));
            } else {
                arrayAnswer.append(letter);
            }
        }
        answer = String.join("", arrayAnswer);
        return answer;
    }
}
