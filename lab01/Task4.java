package lab01;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int strangersCount = scanner.nextInt();
        scanner.nextLine();

        if (strangersCount < 0) {
            System.out.println("Seriously? Why so negative?");
        } else if (strangersCount == 0) {
            System.out.println("Oh, it looks like there is no one here");
        } else {
            for (int i = 0; i < strangersCount; i++) {
                String name = scanner.nextLine();
                System.out.println("Hello, " + name);
            }
        }
    }
}