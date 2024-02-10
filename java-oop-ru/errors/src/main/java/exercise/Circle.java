package exercise;

// BEGIN
class Circle {
    Point point;
    int radius;
    Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (getRadius() < 0) {
            throw new NegativeRadiusException("");
        }

        return Math.PI * (radius * radius);
    }
}
// END
