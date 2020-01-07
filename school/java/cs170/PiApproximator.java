//SUBMITTED BY: Randy Truong
//HELPED BY: Andrew Yin

import java.awt.Color;

import java.util.Random;
import java.util.Scanner;

import acm.breadboards.OneButtonBreadboard;
import acm.graphics.GLabel;
import acm.graphics.GOval;

public class PiApproximator extends OneButtonBreadboard {

	
	static double PI;
	
	final double DOT_SIZE = 10;
	final int DELAY_IN_MILLISECONDS = 20;
	
	int dotsToDraw = 0;
	int dotsDrawn = 0;
	double yellowDotsOnly = 0;
	Random random = new Random();
	
	
	public void run() {
		this.setSize(500,500);
		this.getTextArea().setText("This program approximates the value of pi by throwing darts randomly"
				+ " at a unit square and computing the percentage that also land within a unit quarter-circle."
				+ " Enter the number of darts to be thrown, and then click the 'Go' button.");
		this.getButton().setText("Go");
		this.getTimer().setDelay(DELAY_IN_MILLISECONDS);

		

	}

	public void onButtonClick() {
		String userInput = this.getUserInput();
		Scanner scanner = new Scanner(userInput);
		dotsToDraw = scanner.nextInt();
		scanner.close();
	
		this.getTimer().start();
	}
	
	
	
	
	public void onTimerTick() {

		

		double x = random.nextDouble()*500;
		double y = random.nextDouble()*500;
		
		GOval dot = new GOval(x, y, DOT_SIZE,DOT_SIZE);

		dot.setFilled(true);
		// x^2 + y^2 = r^2
		if ((Math.pow(x, 2)) + (Math.pow(500-y, 2)) <= 500*500) {
			dot.setFillColor(Color.YELLOW);
			yellowDotsOnly++;
		}	
			else if ((Math.pow(x, 2)) + (Math.pow(500-y, 2)) > 500*500) {
				dot.setFillColor(Color.RED);	
			}

		this.add(dot);
		

		
		dotsDrawn++;
		if (dotsDrawn == dotsToDraw) {
			this.getTimer().stop();
			
			double approximation = (yellowDotsOnly/dotsToDraw) * 4;
			GLabel label = new GLabel("Pi was approximated as " + approximation);
			label.setLocation(20, 350);

			this.add(label);
		


	
		}
		
	
	}
	
	
}
