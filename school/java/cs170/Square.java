//SUBMITTED BY: Randy Truong
//HELPED BY: Tracy Hu
//HELPED BY: Nicole Pan
//HELPED BY: Ender Schmidt


import java.awt.Color;




public class Square extends Rectangle {

	double base;
	double height;
	boolean isFilled;
	Color color;

	

		
		
	}

	public double getBase() {
		return base;
	}
	
	public void setBase(double base) {
		this.base = base;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = base;
	}
	
	public double getArea() {
		return base*base;
	}
	
	public double getPerimeter() {
		return 4*base;
	}
}
