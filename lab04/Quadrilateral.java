public class Quadrilateral extends Figure {
    private Point a;
    private Point b;
    private Point c;
    private Point d;

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        double s = Math.abs((a.getX() * b.getY() - b.getX() * a.getY()
                + b.getX() * c.getY() - c.getX() * b.getY()
                + c.getX() * d.getY() - d.getX() * c.getY()
                + d.getX() * a.getY() - a.getX() * d.getY()) / 2.0);
        if (s == 0) {
            throw new IllegalArgumentException("Чотирикутник є виродженим");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    @Override
    public double area() {
        return Math.abs((a.getX() * b.getY() - b.getX() * a.getY()
                + b.getX() * c.getY() - c.getX() * b.getY()
                + c.getX() * d.getY() - d.getX() * c.getY()
                + d.getX() * a.getY() - a.getX() * d.getY()) / 2.0);
    }

    @Override
    public Point centroid() {
        double x = (a.getX() + b.getX() + c.getX() + d.getX()) / 4.0;
        double y = (a.getY() + b.getY() + c.getY() + d.getY()) / 4.0;
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "Quadrilateral[A" + a + " B" + b + " C" + c + " D" + d + "]";
    }
}
