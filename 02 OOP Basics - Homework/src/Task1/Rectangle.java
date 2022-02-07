package Task1;

public class Rectangle {

    private double width;
    private double length;
    private static int totalRectangles;
    private int rectangleNumber = 0;

    public Rectangle(double width, double length) {
        this.setWidth(width);
        this.setLength(length);
        totalRectangles++;
        this.rectangleNumber = totalRectangles;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        }
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        }
    }

    public void printDetails(){
        System.out.println("Task1.Rectangle number: " + rectangleNumber
                + "\nPerimeter: " + getPerimeter()
                + "\nArea: " + getArea() + "\n");
    }

    private double getPerimeter() {
        if (width <= 0 || length <= 0) {
            return 0;
        } else {
            double perimeter = 2 * this.width + 2 * this.length;
            return Math.round(perimeter * 100.0) / 100.0;
        }
    }

    private double getArea() {
        if (width <= 0 || length <= 0) {
            return 0;
        } else {
            double area = this.width * this.length;
            return Math.round(area * 100.0) / 100.0;
        }
    }
}
