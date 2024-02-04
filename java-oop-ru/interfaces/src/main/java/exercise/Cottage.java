package exercise;

// BEGIN
class Cottage implements Home {
    double area;
    int floor;

    Cottage(double area, int floor) {
        this.area = area;
        this.floor = floor;
    }
    public double getArea() {
        return area;
    }

    public int compareTo(Home home) {
        var thisArea = getArea();
        var anotherArea = home.getArea();
        return Double.compare(thisArea, anotherArea);
    }

    @Override
    public String toString() {
        return floor
                + " этажный коттедж площадью "
                + area
                + " метров";
    }
}
// END
