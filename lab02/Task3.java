package lab02;

public class Task3 {
    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 3);

        Triangle triangle = new Triangle(a, b, c);

        System.out.println(triangle.area());
        System.out.println(triangle.centroid());
    }

    static class Triangle {
        private Point a;
        private Point b;
        private Point c;

        public Triangle(Point a, Point b, Point c) {
            if (a == null || b == null || c == null) {
                throw new IllegalArgumentException();
            }

            this.a = a;
            this.b = b;
            this.c = c;

            if (area() == 0) {
                throw new IllegalArgumentException();
            }
        }

        public double area() {
            return Math.abs(
                    a.getX() * (b.getY() - c.getY())
                    + b.getX() * (c.getY() - a.getY())
                    + c.getX() * (a.getY() - b.getY())
            ) / 2;
        }

        public Point centroid() {
            double x = (a.getX() + b.getX() + c.getX()) / 3;
            double y = (a.getY() + b.getY() + c.getY()) / 3;

            return new Point(x, y);
        }
    }

    static class Point {
        private double x;
        private double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
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
}