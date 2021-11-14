import java.util.Scanner;

import cryptography.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        System.out.println(Caesar.code(a, b));
    }
}
