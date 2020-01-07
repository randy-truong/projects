package labWeek2;
//SUBMITTED BY: Randy Truong
//HELPED BY: Tracy Hu
//HELPED BY: Nicole Pan
//HELPED BY: Ender Schmidt

import java.util.Scanner;
public class IntervalCheck {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Put in the left endpoint: ");
		int lEndpoint = scanner.nextInt();
		System.out.print("Put in the right endpoint: ");
		int rEndpoint = scanner.nextInt();
		
		
		System.out.print("What number should we test? ");
		double number = scanner.nextDouble();
		
		if (number <= lEndpoint)
			System.out.println(number + " is not in the interval " + "[" + lEndpoint + "," + rEndpoint + "].");
		if (number >= rEndpoint)
			System.out.println(number + " is not in the interval " + "[" + lEndpoint + "," + rEndpoint + "].");
		else
			System.out.println(number + " is in the interval " + "[" + lEndpoint + "," + rEndpoint + "].");
		
		
		scanner.close();
		
		
		
	}

}
