public class Circle extends Figure {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Коло є виродженим");
        }
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public Point centroid() {
        return new Point(center.getX(), center.getY());
    }

    @Override
    public String toString() {
        return "Circle[" + center + " " + radius + "]";
    }
}
