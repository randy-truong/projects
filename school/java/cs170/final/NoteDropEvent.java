//SUBMITTED BY: Randy Truong
//HELPED BY: Steven Chen and Eric Gu


import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import acm.breadboards.NoButtonsBreadboard;
import acm.graphics.GCanvas;
import acm.graphics.GLabel;

	// This class runs a program that allows user to control a character on screen to catch falling objects
	// Depending on object, a certain amount of points is added or subtracted

public class NoteDropEvent extends Main {

	BrainStorm lightbulb;
	BrainStorm brainfart;
	BrainStorm brain;
	Student student;
	
	private int tickNum;
	private int points;
	//int score;
	
	Random r = new Random();
	//GCanvas c;



	public void run() {
		
		// Set canvas size and its qualities
		this.setSize(BREADBOARD_WIDTH, BREADBOARD_HEIGHT);
		this.getRegionPanel(NORTH).setVisible(false);
			//this.getTextArea().setText("You have 20 seconds to complete the exam." + "\n"
			//		+ "Catch lightbulbs for +1 point, brains for +2 points, and brainfarts for -2 point!");

			
		// Instantiates student object that is bound by canvas
			// Calls super Student class to do so
		student = new Student(new Rectangle(BREADBOARD_WIDTH, BREADBOARD_HEIGHT));
		student.setLocation((BREADBOARD_WIDTH - student.getWidth()) / 2, BREADBOARD_HEIGHT-5 - student.getHeight());
		student.setDelay(1);
		// Sets object delay to 1 millisecond


		this.add(student);
		
		// Adds a listener to student object, so that it can be moved with arrow keys, calls ArrowKeyControl superclass
		this.addKeyListeners(student.getKeyListener());

		//newCanvas = this.getGCanvas();
		
		
		//Sets delay of timer, 25 milliseconds between each tick
		this.getTimer().setDelay(25);
		this.getTimer().start();
		this.getGCanvas().requestFocus();
	}

	public void onTimerTick() {
		r = new Random();
		tickNum++;

		
		// Randomly chooses a number between 0 - 14
		// Switches what is added to the canvas according number that is chosen
		int object = r.nextInt(17);
		switch (object) {
		case 0 :
			lightbulb = new Lightbulb(r.nextDouble() * (BREADBOARD_WIDTH - 50), -160);
			this.add(lightbulb);
			lightbulb.setVelocity(0, 2);
			lightbulb.setAcceleration(0, 0.025);
			lightbulb.move();
			break;

		case 1 :
			brainfart = new BrainFart(r.nextDouble() * (BREADBOARD_WIDTH - 50), -160);
			this.add(brainfart);
			brainfart.setVelocity(0, 2);
			brainfart.setAcceleration(0, 0.025);
			brainfart.move();
			break;
			
		case 2 :
			lightbulb = new Lightbulb(r.nextDouble() * (BREADBOARD_WIDTH - 50), -160);
			this.add(lightbulb);
			lightbulb.setVelocity(0, 2);
			lightbulb.setAcceleration(0, 0.025);
			lightbulb.move();
			break;
			
		case 3 :
			brainfart = new BrainFart(r.nextDouble() * (BREADBOARD_WIDTH - 50), -160);
			this.add(brainfart);
			brainfart.setVelocity(0, 2);
			brainfart.setAcceleration(0, 0.025);
			brainfart.move();
			break;
			
		case 5 :
			brain = new Brain(r.nextDouble() * (BREADBOARD_WIDTH - 50), -160);
			this.add(brain);
			brain.setVelocity(0, 2);
			brain.setAcceleration(0, 0.025);
			brain.move();
			break;
			
		default : break;
			
		}
		
		// Looks at how many elements are on the screen, if the Y-value of the objects go past the breadboard height
		// removes them from canvas
		// if the Y-value is not off canvas, then it moves them

		for (int i = 0; i < this.getElementCount(); i++) {

			if (this.getElement(i).getY() > BREADBOARD_HEIGHT) {
				this.remove(this.getElement(i));
			} else if (this.getElement(i) != student) {
				((BrainStorm) this.getElement(i)).move();

			}
		}
		
		// Checks to see if the element on screen is an instance of a subclass and if it touches the character
		// it deducts/adds amount of points

		for (int i = 0; i < this.getElementCount(); i++) {
			if ((this.getElement(i)) instanceof Lightbulb) {
				if (student.getBounds().intersects(this.getElement(i).getBounds())) {
					points++;
					this.remove(this.getElement(i));
					System.out.println(points);
				}
			} 
			else if ((this.getElement(i)) instanceof BrainFart) {
				if (student.getBounds().intersects(this.getElement(i).getBounds())) {
					points -= 2;
					this.remove(this.getElement(i));
					System.out.println(points);
				}
			}
			else if ((this.getElement(i)) instanceof Brain) {
				if (student.getBounds().intersects(this.getElement(i).getBounds())) {
					points += 2;
					this.remove(this.getElement(i));
					System.out.println(points);
				}
			}
			
		}
		
		
		// Stops timer after a certain amount of ticks
		if (tickNum == 1200) {
			this.getTimer().stop();

			if (points >= 30) {
			//	this.getTextArea().setText("You got " + points + " point(s)" + "\n" + "Congratulations, you passed the exam!");
				Main.score += 5;
			} 
		
			else {
			//	this.getTextArea().setText("You got " + points + " point(s)" + "\n" + "Sorry, you failed the exam!");
				Main.score += 1;
			}

			System.out.println(score);
			
			this.setVisible(false);

		}
	/*	else if (tickNum >= 1300) {
			System.out.println("Timer has stopped!");
			this.getTimer().stop();
			this.setVisible(false);
		} */

	}
}
