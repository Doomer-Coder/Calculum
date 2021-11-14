package cryptography;

import java.util.Arrays;
import standard.*;

public class Caesar extends Fields {
    public static String code(String data, String ... strKey) {
        int key;
        String answer = "";
        try {
            key = Integer.parseInt(Arrays.deepToString(strKey));
        } catch (NumberFormatException e) {
            answer = error();
            return answer;
        }
        for (char letter: data.toCharArray()) {
            answer = answer.concat(String.valueOf(ALPHABET.charAt(letter + key)));
        }
        return answer;
    }
}
