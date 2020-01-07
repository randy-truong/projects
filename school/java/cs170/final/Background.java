//SUBMITTED BY: Steven Chen
//HELPED BY: Randy Truong and Eric Gu



import acm.graphics.GCompound;
import acm.graphics.GImage;

	// Class that creates image associated to image file, so that it can be called
	

public class Background extends GCompound {
	private GImage image;
	public Background(int n) {
		image = new GImage("background" + n + ".png");
		image.setSize(Main.BREADBOARD_WIDTH, Main.BREADBOARD_HEIGHT);
		image.setVisible(true);
		image.sendToBack();
		this.add(image);
	}
}
