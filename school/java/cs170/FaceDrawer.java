//SUBMITTED BY: Randy Truong
//HELPED BY: nobody

import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.graphics.GLine;
import acm.graphics.GPen;
import acm.graphics.GRoundRect;
import acm.breadboards.OneButtonBreadboard;
import java.awt.Color;



public class FaceDrawer extends OneButtonBreadboard {

	public void run() {
		
		//Insert text here
		this.getTextArea().setText("An abstract interpretation of a face.");
		
		//code for face
		GRoundRect face = new GRoundRect(233,166);
		face.setLocation(140,115);
		
		Color black = new Color(0,0,0);
		Color white = new Color(255,255,255);
		
		face.setColor(black);
		face.setFilled(true);
		face.setFillColor(Color.CYAN);
		
		this.add(face);
		
		this.setSize(500,500);
		
		GOval leftEye = new GOval(35,35);
		leftEye.setLocation(187,150);
		
		Color red = new Color(156,30,15);
		Color redder = new Color(255,30,15);
		
		leftEye.setColor(black);
		leftEye.setFilled(true);
		leftEye.setFillColor(Color.BLACK);
		
		GOval rightEye = new GOval(50,50);
		rightEye.setLocation(270,150);
		
		rightEye.setColor(black);
		rightEye.setFilled(true);
		rightEye.setFillColor(Color.RED);
		
		this.add(leftEye);
		this.add(rightEye);
		
		GRect mouth = new GRect(100,20);
		mouth.setLocation(195,250);
		
		mouth.setColor(black);
		mouth.setFilled(true);
		mouth.setFillColor(Color.DARK_GRAY);
		
		GRect nose = new GRect(15,15);
		nose.setLocation(243,200);
		
		nose.setColor(black);
		nose.setFilled(true);
		nose.setFillColor(Color.YELLOW);
	
		
		this.add(mouth);

		
		GLine whisker1 = new GLine(150,210,250,210);
		whisker1.setColor(black);
		GLine whisker2 = new GLine(250,210,360,210);
		whisker2.setColor(black);
		GLine whisker3 = new GLine(150,245,250,210);
		whisker3.setColor(black);
		GLine whisker4 = new GLine(250,210,360,245);
		whisker4.setColor(black);
		GLine lip = new GLine(195,260,295,260);
		lip.setColor(redder);
		
		this.add(whisker1);
		this.add(whisker2);
		this.add(whisker3);
		this.add(whisker4);
		this.add(nose);
		this.add(lip);
		
		
		GPen pen = new GPen();
		this.add(pen);
		
		pen.setLocation(getX(), getY());
		
		pen.move(275, 155);
		pen.setColor(white);
		pen.drawLine(40, 40);

		

		
		
		
		
	}

}
