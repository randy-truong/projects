//SUBMITTED BY: Randy Truong
//HELPED BY: nobody

import java.util.Random;

import acm.breadboards.NoButtonsBreadboard;

public class FruitDrop extends NoButtonsBreadboard {

	Fruit[] orange;
	Fruit[] apple;
	Fruit[] cherries;

	Random r = new Random();
	
	public static final int BREADBOARD_WIDTH = 500;
	public static final int BREADBOARD_HEIGHT = 500;

	public void run() {

		this.setSize(BREADBOARD_WIDTH, BREADBOARD_HEIGHT);
		this.getTextArea().setText("It's raining fruit!");
		
		

/*		orange = new Fruit[3];
		apple = new Fruit[3];
		cherries = new Fruit[3];

		for (int i = 0; i < 3; i++) {
			orange[i] = new Orange(75 + 125 * i, 100 * i % 300);
			orange[i].setVelocity(0, 3 - 2 * Math.random());
			orange[i].setAcceleration(0, 0.1*i);
			
			apple[i] = new Apple(75 + 125 * i, 100 * i % 300);
			apple[i].setVelocity(0, 3 - 2 * Math.random());
			apple[i].setAcceleration(0, 0.1*i);
			
			cherries[i] = new Cherries(75 + 125 * i, 100 * i % 300);
			cherries[i].setVelocity(0, 3 - 2 * Math.random());
			cherries[i].setAcceleration(0, 0.1*i);
	
			
			this.add(orange[i]);
			this.add(apple[i]);
			this.add(cherries[i]);

		} 
		*/

		orange = new Fruit[1 + r.nextInt(9)];
		apple = new Fruit[1 + r.nextInt(9)];
		cherries = new Fruit[1 + r.nextInt(9)];
		
		for (int i = 0; i < orange.length; i++) {
			orange[i] = new Orange(r.nextDouble() * 400, -160);
			//orange[i] = new Orange(25 + 125 * i, 100 * i % 300);
			orange[i].setVelocity(0, 2.6 - 2 * Math.random());
			orange[i].setAcceleration(0, 0.1);
			this.add(orange[i]);
		}
		
		for (int i = 0; i < apple.length; i++) {
			apple[i] = new Apple(r.nextDouble() * 400, -160);
			//apple[i] = new Apple(25 + 125 * i, 100 * i % 300);
			apple[i].setVelocity(0, 2.6 - 2 * Math.random());
			apple[i].setAcceleration(0, 0.1);
			this.add(apple[i]);
		}
		
		for (int i = 0; i < cherries.length; i++) {
			cherries[i] = new Cherries(r.nextDouble() * 400, -160);
			//cherries[i] = new Cherries(25 + 125 * i, 100 * i % 300);
			cherries[i].setVelocity(0, 2.6 - 2 * Math.random());
			cherries[i].setAcceleration(0, 0.1);
			this.add(cherries[i]);
		} 


		this.getTimer().setDelay(20);
		this.getTimer().start();
	}

	public void onTimerTick() {

		for (int i = 0; i < orange.length; i++) {
			orange[i].move();
		}
		for (int i = 0; i < apple.length; i++) {
			apple[i].move();
		}
		for (int i = 0; i < cherries.length; i++) {
			cherries[i].move();
		}

	}
}
