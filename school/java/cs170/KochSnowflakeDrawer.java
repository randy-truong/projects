//SUBMITTED BY: Randy Truong
//HELPED BY: nobody




import java.util.Scanner;
import acm.breadboards.OneButtonBreadboard;
import acm.toys.Turtle;





public class KochSnowflakeDrawer extends OneButtonBreadboard {
	final String DIRECTIONS = "This program will use a turtle to draw the nth stage in the construction "
			+ "of a Koch snowflake. Enter the value of n and click the 'Go' button";
	
	Turtle turtle;

	


	public void run() {
		this.getTextArea().setText(DIRECTIONS);
		this.getButton().setText("Go");
		turtle = new Turtle();
		turtle.right(60);
		turtle.setLocation(250, 80);
		this.add(turtle);

	}
	
	public void onButtonClick() {

		int stage;
        double size = 210.0;


		String userInputStr = this.getTextField().getText();
		
		Scanner scanner = new Scanner(userInputStr);
		String command = scanner.next();

		
		switch (command) {
			case "0":
				stage = Integer.parseInt(command);
		        size = size / Math.pow(3, stage);
				for (int i = 0; i < 3; i++) {
					drawKoch(stage, size);
					turtle.right(120);
				} 
				turtle.hideTurtle();
				break; 
		
			case "1":
				stage = Integer.parseInt(command);
		        size = size / Math.pow(3, stage);
				for (int i = 0; i < 3; i++) {
					drawKoch(stage, size);
					turtle.right(120);
				}
				turtle.hideTurtle();
				break;
			
			case "2":
				stage = Integer.parseInt(command);
		        size = size / Math.pow(3, stage);
				for (int i = 0; i < 3; i++) {
					drawKoch(stage, size);
					turtle.right(120);
				}
				turtle.hideTurtle();
				break;
				
			case "3":
				stage = Integer.parseInt(command);
		        size = size / Math.pow(3, stage);
				for (int i = 0; i < 3; i++) {
					drawKoch(stage, size);
					turtle.right(120);
				}
				turtle.hideTurtle();
				break;
				
			case "4":
				stage = Integer.parseInt(command);
		        size = size / Math.pow(3, stage);
				for (int i = 0; i < 3; i++) {
					drawKoch(stage, size);
					turtle.right(120);
				}
				turtle.hideTurtle();
				break;
				
			case "5":
				stage = Integer.parseInt(command);
		        size = size / Math.pow(3, stage);
				for (int i = 0; i < 3; i++) {
					drawKoch(stage, size);
					turtle.right(120);
				}
				turtle.hideTurtle();
				break;
			
		
            case "go-fast": 
            	turtle.setSpeed(1);
            	break;	                            
        	
            case "clear": 
            	this.removeAll();
            	run();
            	break;
            						
		}
		
	}
		
	public void drawKoch(int num, double size) {
		if (num == 0) {
			turtle.forward(size);
		}
		else {
			drawKoch(num-1, size);
			turtle.right(-60);
			drawKoch(num-1, size);
			turtle.right(120);
			drawKoch(num-1, size);
			turtle.right(-60);
			drawKoch(num-1, size);

		}  

		
		
	}
	
}

	