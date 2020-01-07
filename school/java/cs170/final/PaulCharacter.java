import acm.graphics.GCompound;
import acm.graphics.GImage;


// Class that creates image associated to image file, so that it can be called
public class PaulCharacter extends GCompound {

	private GImage image;
	
	public PaulCharacter(double x, double y) {
		// Checks for image in bin that contains the project files
		image = new GImage("paul.png");
		this.add(image);
		this.setLocation(x, y);
	}
	
}
	
