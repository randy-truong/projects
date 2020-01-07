import acm.graphics.GCompound;
import acm.graphics.GImage;

public class FirstEndingBackground extends GCompound {

	private GImage image;
	public FirstEndingBackground(int n) {
		image = new GImage("ending1" + "-" + n + ".png");
		image.setSize(Main.BREADBOARD_WIDTH, Main.BREADBOARD_HEIGHT);
		image.sendToBack();
		this.add(image);
	}
}
