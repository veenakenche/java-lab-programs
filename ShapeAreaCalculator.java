import java.util.Scanner;
abstract class Shape {
    int dimension1;
    int dimension2;
    abstract void printArea();
}
class Rectangle extends Shape {
    Rectangle(int width,int height) {
        dimension1 = width;
        dimension2 = height;
    }
    void printArea() {
        int area = dimension1 * dimension2;
        System.out.println("Area of Rectangle: " + area);
    }
}
class Triangle extends Shape {
    Triangle(int base,int height) {
        dimension1 = base;
        dimension2 = height;
    }
    void printArea() {
        double area = 0.5 * dimension1 * dimension2;
        System.out.println("Area of Triangle: " + area);
    }
}
class Circle extends Shape {
    Circle(int radius) {
        dimension1 = radius;
    }
    void printArea() {
        double area = Math.PI * dimension1 * dimension1;
        System.out.println("Area of Circle: " + area);
    }
}
public class ShapeAreaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter width of Rectangle: ");
        int rectangleWidth = scanner.nextInt();
        System.out.print("Enter height of Rectangle: ");
        int rectangleHeight = scanner.nextInt();
        Shape rectangle = new Rectangle(rectangleWidth, rectangleHeight);
        rectangle.printArea();
        System.out.print("Enter base of Triangle: ");
        int triangleBase = scanner.nextInt();
        System.out.print("Enter height of Triangle: ");
        int triangleHeight = scanner.nextInt();
        Shape triangle = new Triangle(triangleBase, triangleHeight);
        triangle.printArea();
        System.out.print("Enter radius of Circle: ");
        int circleRadius = scanner.nextInt();
        Shape circle = new Circle(circleRadius);
        circle.printArea();

        scanner.close();
    }
}
