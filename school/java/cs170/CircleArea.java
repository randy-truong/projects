package labWeek1;
import java.util.Scanner;

//SUBMITTED BY: Randy Truong
//HELPED BY: Tracy Hu
//HELPED BY: Nicole Pan
//HELPED BY: Ender Schmidt

public class CircleArea {

	public static void main(String[] args) {
		
		Scanner circle = new Scanner(System.in);
		System.out.print("What is your radius? ");
		
		double radius = circle.nextDouble();
		
		
		System.out.print("The area of the circle is " + Math.PI*Math.pow(radius, 2));
		
		circle.close();
		
	}

}
