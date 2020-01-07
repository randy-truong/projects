import acm.graphics.GCompound;
import acm.graphics.GImage;

public class ThirdEndingBackground extends GCompound {

	private GImage image;
	public ThirdEndingBackground(int n) {
		image = new GImage("ending3" + "-" + n + ".png");
		image.setSize(Main.BREADBOARD_WIDTH, Main.BREADBOARD_HEIGHT);
		image.sendToBack();
		this.add(image);
	}
}
