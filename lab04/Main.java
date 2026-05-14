public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(
                new Point(0, 0),
                new Point(4, 0),
                new Point(0, 3));
        System.out.println(triangle);
        System.out.println("Площа: " + triangle.area());
        System.out.println("Центроїд: " + triangle.centroid());

        Quadrilateral quad = new Quadrilateral(
                new Point(0, 0),
                new Point(4, 0),
                new Point(4, 3),
                new Point(0, 3));
        System.out.println(quad);
        System.out.println("Площа: " + quad.area());
        System.out.println("Центроїд: " + quad.centroid());

        Circle circle = new Circle(new Point(2, 2), 5);
        System.out.println(circle);
        System.out.println("Площа: " + circle.area());
        System.out.println("Центроїд: " + circle.centroid());
    }
}
