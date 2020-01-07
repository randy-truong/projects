//SUBMITTED BY: Randy Truong
//HELPED BY: nobody

import acm.graphics.GImage;

public class Apple extends Fruit {

	private GImage image;

	public Apple(double x, double y) {
		image = new GImage("apple.png");
		this.add(image);
		this.setLocation(x, y);
	}

	public void move() {
		double vx = this.getXVelocity();
		double vy = this.getYVelocity();
		this.setAcceleration(0, 0.01);
		this.setLocation(this.getX() + vx, this.getY() + vy);
		this.setVelocity(vx + this.getXAcceleration(), vy + this.getYAcceleration());

		if (this.getY() > FruitDrop.BREADBOARD_HEIGHT) {
			this.setLocation(this.getX(), -100 + -this.image.getHeight());
		}
	}
}
