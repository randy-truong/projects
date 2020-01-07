//SUBMITTED BY: Randy Truong
//HELPED BY: Steven Chen and Eric Gu


import acm.graphics.GImage;


	
	// Class that creates image associated to image file, so that it can be called
	// Extends abstract class BrainStorm, to allow it to move on canvas
public class Lightbulb extends BrainStorm {

	private GImage image;
	
	public Lightbulb(double x, double y) {
		// Checks for image in bin that contains the project files
		image = new GImage("lightbulb.png");
		this.add(image);
		this.setLocation(x, y);
	}
	
}