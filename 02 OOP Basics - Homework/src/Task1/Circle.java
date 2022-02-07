package Task1;

public class Circle {

    private double radius;
    private static int totalCircles = 0;
    private int circleNumber;

    public Circle(double radius) {
        this.setRadius(radius);
        totalCircles++;
        this.circleNumber = totalCircles;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        }
    }

    public void printDetails(){
        System.out.println("Task1.Circle number: " + circleNumber
                + "\nPerimeter: " + getPerimeter()
                + "\nArea: " + getArea() + "\n");
    }

    private double getPerimeter() {
        double perimeter = 2 * (Math.PI * this.radius);
        return Math.round(perimeter * 100.0) / 100.0;
    }

    private double getArea() {
        double area = Math.PI * (this.radius * this.radius);
        return Math.round(area * 100.0) / 100.0;
    }
}
