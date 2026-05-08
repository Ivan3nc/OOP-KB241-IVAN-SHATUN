package lab01;

import java.util.Scanner;

public class Task3 {
    final static int password = 12345;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputPassword = scanner.nextInt();

        if (inputPassword == password) {
            System.out.println("Hello, Agent");
        } else {
            System.out.println("Access denied");
        }
    }
}
