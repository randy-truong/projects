package labWeek4;
//SUBMITTED BY: Randy Truong
//HELPED BY: Tracy Hu
//HELPED BY: Nicole Pan
//HELPED BY: Ender Schmidt


//CS 170 - Oxford College
//
//Craps is a graphical program that will run the game of craps, minus betting.
//It combines all material done so far, including graphics, conditionals, and other
//things.  It's used to demonstrate what a true java Class looks like, with constants
//and variables at the top and methods below.  It's also a good demonstration of scope.

import java.awt.Color;

import acm.breadboards.TwoButtonBreadboard;
import acm.toys.Die;

public class Craps extends TwoButtonBreadboard {

	// Constant values
	
	final int DICE_X = 180;
	final int DICE_Y = 150;
	final int SPACING = 100;
	final Color pokerFeltGreen = new Color(71, 113, 72);
	
	// Variables
	
	Die die1;
	Die die2;
	boolean isFirstRoll;
	int point;
	
	// Methods
	
	// The run() method creates the canvas and dice.
	public void run() {
		
		// Canvas setup
		
		this.getGCanvas().setBackground(pokerFeltGreen);
		this.getButton1().setText("Roll!");
		this.getButton2().setText("Start Over");
		this.getTextArea().setText("Roll the dice. If you get 7 or 11, you win!\n" +
									"If you get 2, 3, or 12, you lose!");
		
		// Create the dice and but them on the canvas, but hide them
		
		die1 = new Die();
		die1.setLocation(DICE_X, DICE_Y);
		die1.setVisible(false);
		this.add(die1);

		die2 = new Die();
		die2.setLocation(DICE_X + SPACING, DICE_Y);
		die2.setVisible(false);
		this.add(die2);
    
        // Set it to be the first roll
        
        isFirstRoll = true;
        
	}
	
	// This method runs if the player clicks the "Roll!" button
	public void onButton1Click() {
				
		// First, calculate the dice roll and show the player
		int sumOfDice = die1.roll() + die2.roll();
		die1.setVisible(true);
		die2.setVisible(true);
		
		// Different rules if it is the first roll or not:
		
		if (isFirstRoll) {
			// If it is, 7 or 11 wins; 2, 3, or 12 loses; anything else becomes point
			
			switch(sumOfDice) {
			// Winning
			case 7: ;
			case 11: ; 
				this.getTextArea().setText("You win!");
				this.getButton1().setEnabled(false);
				break;
			
			// Losing
			case 2: ;
			case 3: ;
			case 12: ;
				this.getTextArea().setText("You lose!");
				this.getButton1().setEnabled(false);
				break;
			
			// Continuing	
			default: 
				point = sumOfDice;
				this.getTextArea().setText("You have one more shot. Roll a " + point +
									" before you roll a 7 and you win!");
				isFirstRoll = false;
					
			}
		
		}
		else {
			
			if (point == sumOfDice) {
				// Winning!
				this.getTextArea().setText("You win!");
				this.getButton1().setEnabled(false);	
			}
			else if (sumOfDice == 7) {
				// Losing!
				this.getTextArea().setText("You lose!");
                this.getButton1().setEnabled(false);
            }
			
			
		}
	
	}
	
	// This method runs if the user clicks "Start Over"
	public void onButton2Click() {
	
		this.getTextArea().setText("Roll the dice.  If you get a 7 or 11, you win!\n" +
                "If you get a 2, 3, or 12, you lose!");
		isFirstRoll = true;
		die1.setVisible(false);
		die2.setVisible(false);
		this.getButton1().setEnabled(true);
		
	}
	
}
