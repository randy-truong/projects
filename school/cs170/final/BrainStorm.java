//SUBMITTED BY: Randy Truong
//HELPED BY: Steven Chen and Eric Gu


import acm.graphics.GCompound;

	// This class gives gravitational motion to objects that extend it

public abstract class BrainStorm extends GCompound implements Collision {
	
	private double vx;
	private double vy;
	private double ax;
	private double ay;

	public double getXVelocity() {
		return vx;
	}

	public double getYVelocity() {
		return vy;
	}

	public double getXAcceleration() {
		return ax;
	}

	public double getYAcceleration() {
		return ay;
	}

	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}

	public void setAcceleration(double ax, double ay) {
		this.ax = ax;
		this.ay = ay;
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

	// Moves objects to the values it was set at

	public void move() {
		double vx = this.getXVelocity();
		double vy = this.getYVelocity();
		this.setAcceleration(0, 0.05);
		this.setLocation(this.getX() + vx, this.getY() + vy);
		this.setVelocity(vx + this.getXAcceleration(), vy + this.getYAcceleration());

	/*	if (this.getY() > NoteDrop.BREADBOARD_HEIGHT) {
			this.setLocation(this.getX(), -100 + -this.image.getHeight()); */
	}
		


}
