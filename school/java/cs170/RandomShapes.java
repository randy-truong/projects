package labWeek2;
//SUBMITTED BY: Randy Truong
//HELPED BY: Tracy Hu
//HELPED BY: Nicole Pan
//HELPED BY: Ender Schmidt

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.graphics.GLine;
import acm.breadboards.OneButtonBreadboard;

import java.awt.Color;
import java.util.Random;




public class RandomShapes extends OneButtonBreadboard {

	public void run() {
		
		
		this.setSize(500,500);	
		Random r = new Random();
		GOval oval = new GOval(50,50);
		oval.setLocation(r.nextInt(500), r.nextInt(500));
		
		Color randomColor = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
		oval.setColor(randomColor);
		oval.setFilled(true);
		oval.setFillColor(randomColor);
		
		this.add(oval);

		
		GRect rect = new GRect(r.nextInt(500), r.nextInt(500));
		rect.setLocation(r.nextInt(500), r.nextInt(500));
		rect.setColor(randomColor);
		rect.setFilled(true);
		
		
		this.add(rect);
		
		//GLine line = new GLine(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
		//line.setColor(rect.setColor(randomColor));
		//this.add(line);
		
		

	
		

	}

}
