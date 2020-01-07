// Name: Randy Truong
// Assignment 1

package Assignment1;

public class LinearEquations {
    private double a, b, c, d, e, f;

    LinearEquations() {}

    // Constructor for all variables in 2x2 linear equation:
    // ax + by = e
    // cx + dy = f
    LinearEquations(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;

    }

    // Getters for variables
    double getA() { return this.a; }
    double getB() { return this.b; }
    double getC() { return this.c; }
    double getD() { return this.d; }
    double getE() { return this.e; }
    double getF() { return this.f; }

    // Returns true if equation is solvable
    boolean isSolvable() {
        return (this.a*this.d - this.b*this.c != 0);
    }

    // Returns 'x' solution to LE
    double getX() {
        // Cramer's Rule for solving for 'x'
        double determinant = this.a*this.d - this.c*this.b;
        double determinantX = this.e*this.d - this.f*this.b;
        double x = determinantX/determinant;
        return x;

    }

    // Returns 'y' solution to LE
    double getY() {
        // Cramer's Rule for solving for 'y'
        double determinant = this.a*this.d - this.c*this.b;
        double determinantY = this.a*this.f - this.c*this.e;
        double y = determinantY/determinant;
        return y;
    }

}
