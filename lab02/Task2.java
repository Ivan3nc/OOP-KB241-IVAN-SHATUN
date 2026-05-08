package lab02;

public class Task2 {
    public static void main(String[] args) {
        Point start = new Point(0, 0);
        Point end = new Point(4, 0);

        Segment segment = new Segment(start, end);

        System.out.println(segment.length());
        System.out.println(segment.middle());

        Segment another = new Segment(new Point(2, -2), new Point(2, 2));
        System.out.println(segment.intersection(another));
    }

    static class Segment {
        private Point start;
        private Point end;

        public Segment(Point start, Point end) {
            if (start == null || end == null || start.equals(end)) {
                throw new IllegalArgumentException();
            }

            this.start = start;
            this.end = end;
        }

        public double length() {
            double dx = end.getX() - start.getX();
            double dy = end.getY() - start.getY();

            return Math.sqrt(dx * dx + dy * dy);
        }

        public Point middle() {
            double x = (start.getX() + end.getX()) / 2;
            double y = (start.getY() + end.getY()) / 2;

            return new Point(x, y);
        }

        public Point intersection(Segment another) {
            double x1 = start.getX();
            double y1 = start.getY();
            double x2 = end.getX();
            double y2 = end.getY();

            double x3 = another.start.getX();
            double y3 = another.start.getY();
            double x4 = another.end.getX();
            double y4 = another.end.getY();

            double denominator = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);

            if (denominator == 0) {
                return null;
            }

            double px = ((x1 * y2 - y1 * x2) * (x3 - x4)
                    - (x1 - x2) * (x3 * y4 - y3 * x4)) / denominator;

            double py = ((x1 * y2 - y1 * x2) * (y3 - y4)
                    - (y1 - y2) * (x3 * y4 - y3 * x4)) / denominator;

            if (isBetween(px, py, start, end) && isBetween(px, py, another.start, another.end)) {
                return new Point(px, py);
            }

            return null;
        }

        private boolean isBetween(double x, double y, Point a, Point b) {
            return x >= Math.min(a.getX(), b.getX())
                    && x <= Math.max(a.getX(), b.getX())
                    && y >= Math.min(a.getY(), b.getY())
                    && y <= Math.max(a.getY(), b.getY());
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

        public boolean equals(Point another) {
            return this.x == another.x && this.y == another.y;
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