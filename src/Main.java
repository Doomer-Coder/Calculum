import java.util.Scanner;

import cryptography.*;
import informatics.Notation;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        String c = scanner.nextLine();
        System.out.println(Notation.conversion(a, b, c));
    }
}
