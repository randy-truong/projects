//SUBMITTED BY: Randy Truong
//HELPED BY: nobody


public class IsItALeapYear {

	public static void main(String[] args) {
		
		int x = Integer.parseInt(args[0]);
		
		
		boolean xIsDiv4 = (x%4 == 0);
		boolean xIsDiv400 = (x%400 == 0);
		boolean xIsDiv100 = (x%100 == 0);
		

		if ((xIsDiv4 && !xIsDiv100) || (xIsDiv400))
			// checks if x is divisible by 4 and not divisible by 100 or if x is divisible by 4002
			System.out.println(x + " is a leap year");
		else 
			System.out.println(x + " is not a leap year");
			
		
		
		
		
	}

}
