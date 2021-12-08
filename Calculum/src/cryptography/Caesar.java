package cryptography;

import standard.*;

public class Caesar extends Fields {
    protected static final String ENGLISH_ALPHABET = alphabetBuilder('A', 'Z');
    protected static final String RUSSIAN_ALPHABET = alphabetBuilder('А', 'Я');

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
            if (RUSSIAN_ALPHABET.contains(String.valueOf(letter))) {
                newIndex = (RUSSIAN_ALPHABET.indexOf(letter) + key) % RUSSIAN_ALPHABET.length();
                arrayAnswer.append(RUSSIAN_ALPHABET.charAt(newIndex));
            } else {
                arrayAnswer.append(letter);
            }
        }
        answer = String.join("", arrayAnswer);
        return answer;
    }
}
