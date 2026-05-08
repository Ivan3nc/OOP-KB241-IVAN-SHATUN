package lab02;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double k1 = scanner.nextDouble();
        double b1 = scanner.nextDouble();

        double k2 = scanner.nextDouble();
        double b2 = scanner.nextDouble();

        Line line1 = new Line(k1, b1);
        Line line2 = new Line(k2, b2);

        System.out.println(line1.intersection(line2));
    }
}

class Line {
    private double k;
    private double b;

    public Line(double k, double b) {
        this.k = k;
        this.b = b;
    }

    public Point intersection(Line another) {
        if (this.k == another.k) {
            return null;
        }

        double x = (another.b - this.b) / (this.k - another.k);
        double y = this.k * x + this.b;

        return new Point(x, y);
    }
}

class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + format(x) + ";" + format(y) + ")";
    }

    private String format(double value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        }

        return String.valueOf(value);
    }
}