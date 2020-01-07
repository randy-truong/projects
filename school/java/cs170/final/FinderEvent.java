
//SUBMITTED BY: Randy Truong
//HELPED BY: Steven Chen and Eric Gu

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.JTextArea;
import javax.swing.Timer;

import acm.breadboards.NoButtonsBreadboard;
import acm.graphics.GCanvas;
import acm.graphics.GRect;

public class FinderEvent extends Main {

	private JTextArea textArea;
	private Timer timer;
	private GRect rect;
	private Random r;
	private Flashlight flashlight;
	//public static final int BREADBOARD_WIDTH = 750;
	//public static final int BREADBOARD_HEIGHT = 750;
	private int tickNum;
	private int points;
	private int numClues = 3;

	//public void init() {
	public void run() {
		this.setSize(BREADBOARD_WIDTH, BREADBOARD_HEIGHT);
		this.getRegionPanel(NORTH).setVisible(false);
		this.setBackground(Color.BLACK);



		flashlight = new Flashlight(25, 25);
		flashlight.setLocation(50, 50);
		flashlight.setFilled(true);
		flashlight.setFillColor(Color.YELLOW);
		this.add(flashlight);

		r = new Random();
		rect = new GRect(r.nextDouble()*BREADBOARD_WIDTH, r.nextDouble()*BREADBOARD_HEIGHT, 50, 50);
		//rect = new GRect(50, 50, 50, 50);
		rect.setFilled(true);
		rect.setFillColor(Color.BLACK);
		this.add(rect);
		rect.getLocation();

		System.out.println(rect);
/*		this.getGCanvas().addMouseMotionListener(
				////////////////////////////////////////////
				new MouseMotionListener() {

					@Override
					public void mouseDragged(MouseEvent arg0) {
						//FinderEvent.this.textArea.setText("Mouse now at (" + arg0.getX() + ", " + arg0.getY() + ")");

						// The clue was found at " + "(" + rect.getX() + "," + rect.getY() + ")
					}

					@Override
					public void mouseMoved(MouseEvent arg0) {

					}

				});
		//////////////////////////////////////////// */
		
		this.getTimer().setDelay(1);
		this.getTimer().start();
		this.getGCanvas().requestFocus();
	}
/*		rect.addMouseListener(
				////////////////////////////////////////////
				new MouseListener() {

					public void mouseClicked(MouseEvent arg0) {

					}

					public void mousePressed(MouseEvent arg0) {
					}

					public void mouseReleased(MouseEvent arg0) {
					}

					public void mouseEntered(MouseEvent arg0) {
						rect.setFillColor(Color.RED);
						// System.out.println("The rectangle was found at " + "(" + arg0.getX() + "," +
						// arg0.getY() + ")");
						System.out.println("The clue was found at " + "(" + rect.getX() + "," + rect.getY() + ")");

					}

					public void mouseExited(MouseEvent arg0) {
						rect.setFillColor(Color.BLACK);

					}

				});
		////////////////////////////////////////////
*/
	//}

/*	public void run() {
		flashlight = new Flashlight(50, 50);
		flashlight.setLocation(50, 50);
		flashlight.setFilled(true);
		flashlight.setFillColor(Color.YELLOW);
		this.add(flashlight);

	} */

	public void onTimerTick() {
		tickNum++;

		if (flashlight.getBounds().intersects(rect.getBounds())) {
			points++;
			numClues--;
			//this.getTextArea().setText("You found a clue! Find " + (points - 1) + "more!");
			System.out.println("You found a clue! Find " + numClues + " more!");
			rect.setLocation(r.nextDouble() * (BREADBOARD_WIDTH - 100), r.nextDouble() * (BREADBOARD_HEIGHT - 100));
			if (points == 3) {
				this.getTimer().stop();
				Main.score += 3;
				//this.getTextArea().setText("You have found all the clues!");
				System.out.println("You have found all the clues!");
				this.setVisible(false);
			}

			if (tickNum == 20000) {
				this.getTimer().stop();
				if (points == 3) {
					Main.score += 3;
					// this.getTimer().stop();
					//this.getTextArea().setText("You have found all the clues!");
					System.out.println("You have found all the clues!");
				} else if (points < 3) {
					Main.score += 1;
					//this.getTextArea().setText("You failed!");
					System.out.println("You failed!");
				}
				this.setVisible(false);
			}

		}
	}
}
