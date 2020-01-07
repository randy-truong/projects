// Name: Randy Truong
// CS 171

package Assignment2;

public class Circle extends GeometricObject {

    // Variables
    private double radius;

    // Constructor with no args
    public Circle() {
    }

    // Constructor with 1 double parameter
    public Circle(double radius) {
        this.radius = radius;
    }

    // Constructor with 3 parameters
    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
    }

    // Circle methods for finding radius, diameter, area, circumference
    public double getRadius() {
        return this.radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return radius*radius*Math.PI;
    }
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }
    public double getDiameter() {
        return 2*radius;
    }
    public void printCircle() {
        System.out.println("This is a circle with radius: " + this.radius);
    }

    // Overrides toString() method
    public String toString() {
        return "Circle: radius = " + this.radius;
    }


}
