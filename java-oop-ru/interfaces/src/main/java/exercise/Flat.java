package exercise;

// BEGIN
class Flat implements Home {
    double area;
    double balconyArea;
    int floor;

    Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }
    public double getArea() {
        return area + balconyArea;
    }

    public int compareTo(Home home) {
        var thisArea = getArea();
        var anotherArea = home.getArea();
        return Double.compare(thisArea, anotherArea);
    }

    @Override
    public String toString() {
        return "Квартира площадью "
                + getArea()
                + " метров на "
                + floor
                + " этаже";
    }
}
// END
