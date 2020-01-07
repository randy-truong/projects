import acm.graphics.GCompound;
import acm.graphics.GImage;


// Class that creates image associated to image file, so that it can be called
public class StevenCharacter extends GCompound {

	private GImage image;
	
	public StevenCharacter(double x, double y) {
		// Checks for image in bin that contains the project files
		image = new GImage("randy.png");
		this.add(image);
		this.setLocation(x, y);
	}
	
}
	