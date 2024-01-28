package exercise;

// BEGIN
public class Circle {
    private Point pt;
    private int radius;

    public Circle(Point pt, int radius) {
        this.pt = pt;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Ошибочка");
        }
        return 3.1415926535 * radius * radius;
    }
}
// END
