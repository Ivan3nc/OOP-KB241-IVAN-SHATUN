package lab01;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            System.out.println("no roots");
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            System.out.println(formatNumber(root));
        } else {
            double root1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b + Math.sqrt(discriminant)) / (2 * a);

            System.out.println(formatNumber(root1) + " " + formatNumber(root2));
        }
    }

    private static String formatNumber(double number) {
        if (number == (int) number) {
            return String.valueOf((int) number);
        }

        return String.valueOf(number);
    }
}