//SUBMITTED BY: Randy Truong
//HELPED BY: nobody

import java.awt.Color;
import acm.graphics.GCompound;
import acm.graphics.GArc;
import acm.graphics.GOval;

public class Cherries extends Fruit {

	private GOval cherry1;
	private GOval cherry2;
	private GArc vine1;
	private GArc vine2;

	public Cherries(double x, double y) {
		cherry1 = new GOval(100, 100, 25, 25);
		cherry1.setFilled(true);
		cherry1.setFillColor(Color.RED);

		cherry2 = new GOval(75, 100, 25, 25);
		cherry2.setFilled(true);
		cherry2.setFillColor(Color.RED);

		vine1 = new GArc(103, 75, 25, 25, 90, 180);
		vine1.setColor(Color.GREEN);
		vine2 = new GArc(85, 75, 53, 103, 90, 65);
		vine2.setColor(Color.GREEN);

		this.add(vine1);
		this.add(vine2);
		this.add(cherry1);
		this.add(cherry2);

		this.setLocation(x, y);

	}

	public void move() {
		double vx = this.getXVelocity();
		double vy = this.getYVelocity();
		this.setAcceleration(0, 0.01);
		this.setLocation(this.getX() + vx, this.getY() + vy);
		this.setVelocity(vx + this.getXAcceleration(), vy + this.getYAcceleration());

		if (this.getY() > FruitDrop.BREADBOARD_HEIGHT) {
			this.setLocation(this.getX(), -100 + -this.vine1.getHeight());
			this.setLocation(this.getX(), -100 + -this.vine2.getHeight());
			this.setLocation(this.getX(), -100 + -this.cherry1.getHeight());
			this.setLocation(this.getX(), -100 + -this.cherry2.getHeight());
		}


	}
}
