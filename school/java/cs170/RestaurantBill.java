package labWeek1;
//SUBMITTED BY: Randy Truong
//HELPED BY: Tracy Hu
//HELPED BY: Nicole Pan
//HELPED BY: Ender Schmidt

public class RestaurantBill {

	public static void main(String[] args) {
		
		double bill = Double.parseDouble(args[0]);
		System.out.println(bill);
		
		double tax = bill*.07;
		double tip = bill*.20;
		
		System.out.println("The tax is " + tax);
		System.out.println("The suggested tip is " + tip);
		System.out.println("The total bill is " + (bill + tax + tip));
		
		
	
				
				
				
	}

}
