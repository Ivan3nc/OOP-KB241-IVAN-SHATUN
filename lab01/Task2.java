package lab01;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalSeconds = scanner.nextInt();

        totalSeconds = totalSeconds % 86400;

        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;

        System.out.printf("%d:%02d:%02d%n", hours, minutes, seconds);
    }
}