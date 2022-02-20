public class Rectangle extends Shape {

    private double width;
    private double length;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    protected double getPerimeter() {
        double perimeter = 2 * (width + length);
        return Math.round(perimeter * 100.0) / 100.0;
    }

    protected double getArea() {
        double area = width * length;
        return Math.round(area * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Rectangle: " +
                "Color: " + super.getColor() +
                "Filled: " + super.isFilled() +
                "Width: " + width +
                "Length: " + length;
    }
}
