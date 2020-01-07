//SUBMITTED BY: Randy Truong
//HELPED BY: Steven Chen and Eric Gu


import java.awt.Rectangle;

import acm.graphics.GImage;



	// Class that creates image associated to image file, so that it can be called
	// Extends ArrowKeyControl to allow it to move on canvas using arrowkeys
public class Student extends ArrowKeyControl implements Collision {

	private GImage student;
	
	public Student(Rectangle bounds) {
		super(bounds);
		student = new GImage("student.png");
		this.add(student);
	}

	public double bottomSide() {
		return this.getY() + this.getHeight();
	}

	public double leftSide() {
		return this.getX();
	}

	public double rightSide() {
		return this.getX() + this.getWidth();
	}

	public double topSide() {
		return this.getY();
	}


	public boolean hasCollidedVertically(Collision c) {
		return this.topSide() < c.bottomSide() || this.bottomSide() > c.topSide(); 	
	}


	public boolean hasCollidedHorizontally(Collision c) {
		return this.leftSide() < c.rightSide() || this.rightSide() > c.leftSide(); 
	}
	
	
	
}
