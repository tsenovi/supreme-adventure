public class Circle extends Shape{

    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private double getArea() {
        double area = Math.PI * (radius * radius);
        return Math.round(area * 100.0) / 100.0;
    }

    private double getPerimeter() {
        double perimeter = 2 * (Math.PI * radius);
        return Math.round(perimeter * 100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Shape: " +
                "Color: " + super.getColor() +
                "Filled: " + super.isFilled();
    }
}
