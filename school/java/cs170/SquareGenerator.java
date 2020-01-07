//SUBMITTED BY: Randy Truong
//HELPED BY: nobody

import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;

import acm.graphics.GRect;
import acm.breadboards.OneButtonBreadboard;

import java.awt.Color;

public class SquareGenerator extends OneButtonBreadboard {
	
	GRect rect;
	int tickNum;
	
	int topPanelHeight;
	int bottomPanelHeight;
	final Random r = new Random();
	
	
	public void run() {
		
		topPanelHeight = this.getRegionPanel(OneButtonBreadboard.NORTH).getHeight();
		bottomPanelHeight = this.getRegionPanel(OneButtonBreadboard.SOUTH).getHeight();
		
		this.setSize(500,500);
		this.getTextArea().setText("Click \"Draw!\" to draw a square."
				+ " It will be of random size, color, and location unless you type \"color = \" followed by"
				+ " \"red\", \"green\", or \"blue\". You may specify the size (i.e., side length) by typing"
				+ " \"size = \" followed by some decimal value.");
		this.getButton().setText("Draw!");
		
	
	}
	
	public void onButtonClick() {
		// get user input
		//this.getTextArea().setText("yes");

		
	
		
		//if (scanner.hasNext("green")) {
		//	rect.setFillColor(Color.GREEN);
		this.removeAll();
			tickNum = 0;
		this.getTimer().setDelay(50);
		this.getTimer().start();
		
		
	
		}
	
	
	public void onTimerTick() {
		//int sideLength = r.nextInt(255);

		
		int sideLength = r.nextInt(200);
		/*rect = new GRect(sideLength, sideLength);
		//rect.setColor(Color.BLACK);
		rect.setLocation(r.nextInt(255),r.nextInt(500-topPanelHeight-bottomPanelHeight)/2);
		rect.setFilled(true);
		rect.setFillColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
		//this.add(rect);
		*/
		
		//if (tickNum % 50 == 0) {
		//	this.add(rect);
		String textInput = this.getUserInput();
		Scanner consoleInput = new Scanner(textInput);
		//String textInput = consoleInput.next();
		
		
		
		switch(textInput) {
		case "color = red" : {
			rect = new GRect(sideLength, sideLength);
			//rect.setColor(Color.BLACK);
			rect.setLocation(r.nextInt(255),r.nextInt(500-topPanelHeight-bottomPanelHeight)/2);
			rect.setFilled(true);
			rect.setFillColor(Color.RED); 
		} break;
		
		
		case "color = blue" : {
			rect = new GRect(sideLength, sideLength);
			//rect.setColor(Color.BLACK);
			rect.setLocation(r.nextInt(255),r.nextInt(500-topPanelHeight-bottomPanelHeight)/2);
			rect.setFilled(true);rect.setFillColor(Color.BLUE); 
		} break;
		
		case "color = green" : {
			rect = new GRect(sideLength, sideLength);
			//rect.setColor(Color.BLACK);
			rect.setLocation(r.nextInt(255),r.nextInt(500-topPanelHeight-bottomPanelHeight)/2);
			rect.setFilled(true);rect.setFillColor(Color.GREEN); 
		} break;
		
		
		default: {
			Scanner integer = new Scanner(textInput);
			if (integer.hasNext()) {
				integer.next();
				integer.next();
				String size = integer.next();
				int number = Integer.parseInt(size);
				
				rect = new GRect(number, number);
				//rect.setColor(Color.BLACK);
				rect.setLocation(r.nextInt(255),r.nextInt(500-topPanelHeight-bottomPanelHeight)/2);
				rect.setFilled(true);
				rect.setFillColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
		
				//String size = integer(textInput);

			}
			else
				{rect = new GRect(sideLength, sideLength);
			//rect.setColor(Color.BLACK);
				rect.setLocation(r.nextInt(255),r.nextInt(500-topPanelHeight-bottomPanelHeight)/2);
				rect.setFilled(true);
				rect.setFillColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
				
				}
			
		}
		//	switch(input1) {
		//	case "size = 
			}
		this.add(rect);
		
	
			tickNum++;
			if (tickNum > 50)
				this.getTimer().stop();
			
			
			
		}
	
	}

//}
