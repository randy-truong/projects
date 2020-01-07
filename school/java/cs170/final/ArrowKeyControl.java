//SUBMITTED BY: Randy Truong
//HELPED BY: Steven Chen and Eric Gu


import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import acm.graphics.GCompound;

	// Class that creates the listeners for an object that calls it
	// Allows the object to move using arrow keys

public class ArrowKeyControl extends GCompound {

	public static final int UP = 38;
	public static final int RIGHT = 39;
	public static final int DOWN = 40;
	public static final int LEFT = 37;
	public static final int STOPPED = -1;

	private int direction;
	private KeyListener keyListener;
	private Timer timer;
	private int delay = 10;
	private int step = 15;
	private Rectangle bounds;

	public KeyListener getKeyListener() {
		return keyListener;
	}

	public int getDelay() {
		return delay;
	}

	public int getStep() {
		return step;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public void setStep(int step) {
		this.step = step;
	}

	
	// Prevents object that uses this class to go beyond the set values
	public void setBounds(int minX, int maxX, int minY, int maxY) {
		bounds = new Rectangle(maxX - minX, maxY - minY);
		bounds.setLocation(minX, minY);
	}

	// Checks if the image is within the bounds
	public boolean inBounds() {
		return (bounds.contains(this.getX(), this.getY())
				&& bounds.contains(this.getX() + this.getWidth(), this.getY() + this.getHeight()));
	}

	public ArrowKeyControl(Rectangle bounds) {
		this.bounds = bounds;
		
		
		// Checks which key is pressed, and performs an action as specified for the object
		keyListener =
				///////////////////////////////////////////////////////////
				new KeyListener() {

					public void keyPressed(KeyEvent arg0) {
						direction = arg0.getKeyCode();
						//ArrowKeyControl.this.timer.start();

					switch (direction) {
					case LEFT:
						ArrowKeyControl.this.move(-step, 0);
						
				
						if (!inBounds())
							ArrowKeyControl.this.move(step, 0);
						break;

					case RIGHT:
						ArrowKeyControl.this.move(step, 0);
						if (!inBounds())
							ArrowKeyControl.this.move(-step, 0);
						break;

					case STOPPED:
						break;

					} 
					}

					public void keyTyped(KeyEvent arg0) {
					}

					public void keyReleased(KeyEvent arg0) {
					}
				};

		///////////////////////////////////////////////////////////
/*		timer = new Timer(delay,
				///////////////////////////////////////////////////////////
				new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						ArrowKeyControl.this.timer.start();
						switch (direction) {

						case LEFT:
							ArrowKeyControl.this.move(-step, 0);
							if (!inBounds())
								ArrowKeyControl.this.move(step, 0);
							break;

						case RIGHT:
							ArrowKeyControl.this.move(step, 0);
							if (!inBounds())
								ArrowKeyControl.this.move(-step, 0);
							break;

						case STOPPED:
							break;

						/*
						 * case UP : ArrowKeyControl.this.move(0, -step); if (! inBounds())
						 * ArrowKeyControl.this.move(0, step); break;
						 */
						/*
						 * case DOWN : ArrowKeyControl.this.move(0, step); if (! inBounds())
						 * ArrowKeyControl.this.move(0, -step); break;
						 

						} 
						}
					}
				}); */
		///////////////////////////////////////////////////////////
	}

}
