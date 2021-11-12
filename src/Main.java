import java.util.Scanner;

import Cryptography.*;
import Informatics.*;
import Maths.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        String c = scanner.nextLine();
        System.out.println(Notation.main(a, b, c));
    }
}
