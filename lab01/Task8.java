package lab01;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int sum = 0;
        int count = 0;

        while (number != 0) {
            sum += number;
            count++;

            number = scanner.nextInt();
        }

        int average = sum / count;
        System.out.println(average);
    }
}