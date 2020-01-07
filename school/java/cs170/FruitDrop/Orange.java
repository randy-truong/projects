//SUBMITTED BY: Randy Truong
//HELPED BY: nobody

import java.awt.Color;

import acm.graphics.GOval;

public class Orange extends Fruit {

	private GOval orange;

	public Orange(double x, double y) {
		orange = new GOval(50, 50, 50, 50);
		orange.setFilled(true);
		orange.setFillColor(Color.ORANGE);
		
		this.add(orange);
		this.setLocation(x,y);

	}


	public void move() {
		
		double vx = this.getXVelocity();
		double vy = this.getYVelocity();
		this.setAcceleration(0, 0.01);
		this.setLocation(this.getX() + vx, this.getY() + vy);
		this.setVelocity(vx + this.getXAcceleration(), vy + this.getYAcceleration());
		
		if (this.getY() > FruitDrop.BREADBOARD_HEIGHT) {
			this.setLocation(this.getX(), -100 + -this.orange.getHeight());
		}

	}
}
