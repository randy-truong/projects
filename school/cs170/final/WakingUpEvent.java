//SUBMITTED BY: Randy Truong
//HELPED BY: Steven Chen and Eric Gu

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import acm.breadboards.NoButtonsBreadboard;
import acm.graphics.GCanvas;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GRect;


	// This class creates an image of a character that when clicked counts the number of clicks.
	// Must click the character a certain amount of times before the timer stops.

public class WakingUpEvent extends Main {


	private GImage image;
	private GRect bed;
	private GLabel button;
	private Color darkBlue = new Color(25, 25, 112);
	private Color skyBlue = new Color(135, 206, 250);

	private int sumClicks;
	private int tickNum;
	private int num;
	private int trigger;
	

	
	
	public void run() {
		// Sets size of canvas and qualities of it
		this.setSize(BREADBOARD_WIDTH, BREADBOARD_HEIGHT);
		//this.getTextArea().setText("Click the character repeatedly to wake up!" + "\n" + 
		//"You have 20 seconds to wake up before your alarm turns off or else you snooze!");

		this.setBackground(darkBlue);
		
		
		// Instantiates image object to associated file
		image = new GImage("purkis-sleeping.png");
		image.setLocation((BREADBOARD_WIDTH-image.getWidth())/2, BREADBOARD_HEIGHT/3);
		this.add(image); // Adds image to canvas

		
		
		//	Sets timer delay to 1 millisecond between each tick
		this.getTimer().setDelay(1);
		
		
		// Adds listener to image so it knows to do something when clicked
		image.addMouseListener(
				////////////////////////////////////////////
				new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent arg0) {
						getTimer().start(); // Start timer when image is clicked
						sumClicks++;
						System.out.println(sumClicks);

					}

					public void mousePressed(MouseEvent arg0) {}

					public void mouseReleased(MouseEvent arg0) {}

					public void mouseEntered(MouseEvent arg0) {}

					public void mouseExited(MouseEvent arg0) {}

				});
		////////////////////////////////////////////
		

	}

	public void onTimerTick() {
		tickNum++;
		//num++;
		// Stops timer after 15000 ticks = 15 seconds
		if (tickNum == 15000) {
			//this.getTimer().stop();
			this.setBackground(skyBlue);
			
			// Adds a certain amount of points to the score if  total clicks is met after timer stops
			
			if (sumClicks >= 110) {
				//this.getTextArea().setText("You clicked " + sumClicks + " time(s)" + "\n" +
				//					"You woke up!");
				Main.score += 4;
				System.out.println(score);
				this.removeAll();
				image = new GImage("purkis-wake.png");
				image.setLocation((BREADBOARD_WIDTH-image.getWidth())/2-30, BREADBOARD_HEIGHT/3);
				this.add(image);
			}
			else {
				//this.getTextArea().setText("You clicked " + sumClicks + " time(s)" + "\n" +
				//		"You did not wake up on time!");
				Main.score += 2;
				System.out.println(score);
				this.removeAll();
				image = new GImage("purkis-sleeping.png");
				image.setLocation((BREADBOARD_WIDTH-image.getWidth())/2, BREADBOARD_HEIGHT/3);
				this.add(image);
			}
			
		}
		else if (tickNum >= 17000) {
			System.out.println("Timer has stopped!");
			this.getTimer().stop();
			this.setVisible(false);
		}

	}

}
