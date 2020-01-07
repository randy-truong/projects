import acm.graphics.GCompound;
import acm.graphics.GImage;


// Class that creates image associated to image file, so that it can be called
public class EricCharacter extends GCompound {

	private GImage image;
	
	public EricCharacter(double x, double y) {
		// Checks for image in bin that contains the project files
		image = new GImage("eric.png");
		this.add(image);
		this.setLocation(x, y);
	}
	
}
	