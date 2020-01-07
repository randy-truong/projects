// Name: Randy Truong
// CS 171

package Assignment2;


public class Triangle extends GeometricObject implements Comparable{

    // Variables
    private double side1, side2, side3 = 1.0;

    // Constructor with no args
    public Triangle() {}

    // Constructor that takes 3 double parameters, 1 for each side length of a triangle
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Getter methods for triangle sides
    public double getSide1() {
        return this.side1;
    }
    public double getSide2() {
        return this.side2;
    }
    public double getSide3() {
        return this.side3;
    }

    // Setter methods for triangle sides
    public void setSide1(double side1) {
        this.side1 = side1;
    }
    public void setSide2(double side2) {
        this.side2= side2;
    }
    public void setSide3(double side3) {
        this.side3 = side3;
    }

    // Method for calculating the area of triangle
    public double getArea() {
        // Heron's Formula for calculating the area of Triangle given 3 side lengths, such that:
        // s = (a + b + c)/2
        // area = Math.sqrt(s*(s-a)*(s-b)*(s-c))
        double s = (this.side1+this.side2+this.side3)/2;
        double area = Math.sqrt(s*(s-this.side1)*(s-this.side2)*(s-this.side3));
        return area;
    }

    // Method for calculating the perimeter of triangle
    public double getPerimeter() {
        double perimeter = this.side1 + this.side2 + this.side3;
        return perimeter;
    }

    // Method for determining if a triangle is equivalent to another triangle
    public boolean equals(Triangle anotherTriangle) {
        // Calculates the sum and product of all of the side lengths of a triangle
        double sumSides = this.side1+this.side2+this.side3;
        double productSides = this.side1*this.side2*this.side3;
        double sumSides2 = anotherTriangle.side1+anotherTriangle.side2+anotherTriangle.side3;
        double productSide2 = anotherTriangle.side1*anotherTriangle.side2*anotherTriangle.side3;

        // If the sum of each triangle and the product of each triangle are equal to each other, then
        // the triangles are equal.
        if ((sumSides == sumSides2) && (productSides == productSide2)) {
            return true;
        }
        return false;
        // The below doesn't always work because this.side1 could equal anotherTriangle.side2 but still be the same triangle.
        //return ((this.side1 == anotherTriangle.side1) && (this.side2 == anotherTriangle.side2) && (this.side3 == anotherTriangle.side3));
    }

    // Overrides the Object toString() method
    public String toString() {
        return "Triangle: side1 = " + this.side1 + " side2 = " + this.side2 + " side 3 = " + this.side3;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
