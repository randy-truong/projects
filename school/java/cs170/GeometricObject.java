//SUBMITTED BY: Randy Truong
//HELPED BY: Tracy Hu
//HELPED BY: Nicole Pan
//HELPED BY: Ender Schmidt

import java.awt.Color;

public abstract class GeometricObject {
	
	
	private Color color;
	private boolean isNotFilled;

	
	public Color getColor() {
		return color;
	}
	public Color setColor(Color color) {
		return this.color;
	}
	
	public boolean isNotFilled() {
		return isNotFilled;
	}
	
	public boolean isFilled() {
		return !isNotFilled;
	}
	
	public Color color() {
		return this.color;
	}
	
	
	public double getArea() {
		return this.getArea();
	}
	
	public double getPerimeter() {
		return this.getPerimeter();
		

	}
	
}

