// Name: Randy Truong
// Assignment 1

package Assignment1;

public class LinearEquationsTest {
    public static void main(String[] args) {

        // Creates a LinearEquations object given 6 double parameters in the following form:
        // ax + by = e
        // cx + dy = f

        LinearEquations test = new LinearEquations(3, 12, 7, -8, -4, 3);

        System.out.println("The linear equation is: " + "\n"
                + test.getA() + "x + " + test.getB() + "y = " + test.getE()
                + "\n"
                + test.getC() + "x + " + test.getD() + "y = " + test.getF());

        // The following prints boolean true, indicating the LE is solvable
        System.out.println(test.isSolvable());

        // The following prints the solutions of 'x' and y' of the given linear equations
        System.out.println("The x value of the LE is: " + test.getX());
        System.out.println("The y value of the LE is: " + test.getY());
    }
}
