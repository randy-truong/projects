// Name: Randy Truong
// CS 171

package Assignment2;

public class ObjectsTest {
    public static void main(String[] args) {

       // Instantiating Triangle & Circle objects
       Triangle testTriangle = new Triangle(3.0, 5.0, 4.0);
       Circle testCircle = new Circle(6.0);

       // Creating array for all GeometricObjects
       GeometricObject[] objectsArray = new GeometricObject[3];

       // Adds Triangle and Circle object to GeometricObject array
       objectsArray[1] = testTriangle;
       objectsArray[2] = testCircle;

       // Prints information about the Triangle and Circle objects, such as
       // area and perimeter
       System.out.println("This triangle has an area of: " + testTriangle.getArea());
       System.out.println("This triangle has a perimeter of: " + testTriangle.getPerimeter());
       System.out.println("This circle has an area of: " + testCircle.getArea());
       System.out.println("This circle has a perimeter of: " + testCircle.getPerimeter());

       // Prints the sum area of all objects in the GeometricObject array
       System.out.println("The sum of all objects: " + GeometricObject.sumArea(objectsArray));

       // Prints an overridden String representation of the Triangle and Circle object
       System.out.println(testTriangle.toString());
       System.out.println(testCircle.toString());

       System.out.println();

       // Using the getter and setter methods for Triangle objects
       System.out.println("Triangle side1 before change: " + testTriangle.getSide1());
       testTriangle.setSide1(12.0);
       System.out.println("Triangle side1 after change: " + testTriangle.getSide1());

       // Instantiating more Triangle objects
       Triangle otherTriangle = new Triangle(12.0, 5.0, 4.0);
       Triangle anotherTriangle = new Triangle(7.0, 9.0, 2.0);
       Triangle anotherAnotherTriangle = new Triangle(9.0, 2.0, 7.0);

       // Comparison tests to determine if a triangle is equal (having the same side lengths) to another triangle
       System.out.println(testTriangle.equals(otherTriangle)); // prints true
       System.out.println(testTriangle.equals(anotherTriangle)); // prints false
       System.out.println(anotherAnotherTriangle.equals(anotherTriangle)); // prints true

    }



}
