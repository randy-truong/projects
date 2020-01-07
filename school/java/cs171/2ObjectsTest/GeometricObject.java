// Name: Randy Truong
// CS 171

package Assignment2;

public class GeometricObject {

    // Variables
    public String color;
    public boolean isFilled;

    // Constructor, no args
    public GeometricObject() {
        color = "BLANK";
        isFilled = false;
    }

    // Setter and getter methods
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public boolean getFilled() {
        return isFilled;
    }

    public double area() {
        return -1;
    }

    // Method for calculating the sum area of all GeometricObject objects
    public static double sumArea(GeometricObject[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            // If the object in array is Triangle, then use the getArea() method for Triangles
            if (a[i] instanceof Triangle) {
                sum += ((Triangle) a[i]).getArea();
            }
            // If the object in array is Circle, then use the getArea() method for Circles
            else if (a[i] instanceof Circle) {
                sum += ((Circle) a[i]).getArea();
            }
            else {
                sum += 0.0;
            }
        }
        return sum;

    }

}


