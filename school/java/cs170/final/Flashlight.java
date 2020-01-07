//SUBMITTED BY: Randy Truong

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import acm.graphics.GOval;

public class Flashlight extends GOval {

	private double xOffset;
	private double yOffset;

	
	// This class creates a Flashlight object that is a draggabled oval object.
	public Flashlight(double width, double height) {
		super(width, height);

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {

				if (Flashlight.this.contains(arg0.getX(), arg0.getY())) {
					Flashlight.this.xOffset = arg0.getX() - Flashlight.this.getX();
					Flashlight.this.yOffset = arg0.getY() - Flashlight.this.getY();
				}
			}

			public void mouseReleased(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent arg0) {
				Flashlight.this.setFillColor(Color.YELLOW);
			}

			public void mouseExited(MouseEvent arg0) {
				Flashlight.this.setFillColor(Color.LIGHT_GRAY);
			}
		});
		this.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent arg0) {

				double newX = arg0.getX() - Flashlight.this.xOffset;
				double newY = arg0.getY() - Flashlight.this.yOffset;
				Flashlight.this.setLocation(newX, newY);
			//	System.out.println("The flashlight location is " + "(" + newX + ", " + newY + ")");
			}

			public void mouseMoved(MouseEvent arg0) {
			}
		});

	}

}
