import acm.graphics.GCompound;
import acm.graphics.GImage;

public class SecondEndingBackground extends GCompound {

	private GImage image;
	public SecondEndingBackground(int n) {
		image = new GImage("ending2" + "-" + n + ".png");
		image.setSize(Main.BREADBOARD_WIDTH, Main.BREADBOARD_HEIGHT);
		image.sendToBack();
		this.add(image);
	}
}
