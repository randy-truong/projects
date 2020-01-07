package labWeek3;
//SUBMITTED BY: Randy Truong
//HELPED BY:

import java.awt.Color;
import java.util.Random;

import acm.breadboards.OneButtonBreadboard;
import acm.graphics.GOval;

public class FlyingCircles extends OneButtonBreadboard {

	GOval oval;
	int tickNum;
	int direction;
	Random r = new Random();
	
	int topPanelHeight;
	int bottomPanelHeight;
	
	
	public void run() {
		
			this.setSize(500,500);
			
			topPanelHeight = this.getRegionPanel(OneButtonBreadboard.NORTH).getHeight();
			bottomPanelHeight = this.getRegionPanel(OneButtonBreadboard.SOUTH).getHeight();
			
			this.getTimer().setDelay(50);
			this.getTimer().start();
			
			
			
			
			
			this.add(oval);
					
			
			
			//this.getTimer().setDelay(TIMER_DELAY);
			//this.getTimer().start();
			
			
	}
	
	public void onTimerTick() {
		
		Color randomColor = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		if (tickNum % 20 == 0) {
			oval = new GOval(50,50);
			oval.setLocation(225, (500-bottomPanelHeight-topPanelHeight)/2 - 25);
			oval.setFilled(true);
			oval.setFillColor(randomColor);
			direction = r.nextInt(4);
			this.add(oval);
		}
		
		switch(direction) {
		case 0: oval.move(8, 0); break;
		case 1: oval.move(0, 8); break;
		case 2: oval.move(-8, 0); break;
		case 3: oval.move(0, -8); break;
		}
		
		
		
		
	}
	
}


