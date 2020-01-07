//SUBMITTED BY: Randy Truong
//HELPED BY: nobody


public class Gcd {

	public static void main(String[] args) {
	
		
		int posA = Integer.parseInt(args[0]);
		int posB = Integer.parseInt(args[1]);
			
		int a = posA;
		int b = posB;
		int r = a%b;
		
		System.out.println(a + " = " + ((a-r)/b) + " * " + b + " + " + r);
		
		
		while (r != 0) {
			a = b;
			b = r;
			r = a%b;
			System.out.println(a + " = " + ((a-r)/b) + " * " + b + " + " + r);
			
		}
		System.out.println("gcd = " + b);
		
	
		
		
		
		
		
	}
	
	
}