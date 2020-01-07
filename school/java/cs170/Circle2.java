//SUBMITTED BY: Randy Truong
//HELPED BY: Tracy Hu
//HELPED BY: Nicole Pan
//HELPED BY: Ender Schmidt

import java.awt.Color;





public class Circle2 extends GeometricObject {

	
	double radius;
	boolean isFilled;
	Color color;

	
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return Math.PI*radius*radius;
	}
	
	public double getPerimeter() {
		return Math.PI*radius*2;
	}
	
	
}
