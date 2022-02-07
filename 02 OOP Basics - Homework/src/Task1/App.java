package Task1;

public class App {

    public static void main(String[] args) {
        Circle firstCircle = new Circle(20);
        firstCircle.printDetails();

        Circle secondCircle = new Circle(0);
        secondCircle.printDetails();

        Rectangle firstRectangle = new Rectangle(-5, 5.5);
        firstRectangle.printDetails();

        Rectangle secondRectangle = new Rectangle(1, 3.5);
        secondRectangle.printDetails();
    }
}
