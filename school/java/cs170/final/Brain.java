//SUBMITTED BY: Randy Truong
//HELPED BY: Steven Chen and Eric Gu

import acm.graphics.GImage;

	// Class that creates image associated to image, so that it can be called
	// Extends abstract class BrainStorm, to allow it to move on canvas

public class Brain extends BrainStorm {

	private GImage image;
	
	public Brain(double x, double y) {
		image = new GImage("brain.png");
		this.add(image);
		this.setLocation(x, y);
	}
	
}
