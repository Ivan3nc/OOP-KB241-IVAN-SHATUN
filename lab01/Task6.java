package lab01;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int billTotal = scanner.nextInt();
        int friendsCount = scanner.nextInt();

        if (billTotal < 0) {
            System.out.println("Bill total amount cannot be negative");
        } else if (friendsCount <= 0) {
            System.out.println("Number of friends cannot be negative or zero");
        } else {
            int totalWithTips = billTotal + billTotal / 10;
            int paymentPart = totalWithTips / friendsCount;

            System.out.println(paymentPart);
        }
    }
}