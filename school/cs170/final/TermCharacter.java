import acm.graphics.GCompound;
import acm.graphics.GImage;


// Class that creates image associated to image file, so that it can be called
public class TermCharacter extends GCompound {

	private GImage image;
	
	public TermCharacter(double x, double y) {
		// Checks for image in bin that contains the project files
		image = new GImage("terminator.png");
		this.add(image);
		this.setLocation(x, y);
	}
	
}
	