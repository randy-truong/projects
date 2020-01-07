//SUBMITTED BY: Randy Truong
//HELPED BY: Tracy Hu
//HELPED BY: Nicole Pan
//HELPED BY: Ender Schmidt



public class RecursiveGCD {

	
	public static int gcd(int a, int b) {
		int r = a%b;
		//int num1 = a;
		//int num2 = b;
		while (r != 0) {
			a = b;
			b = r;
			r = a%b;
		}
		return b;
		//return "The gcd of " + num1 + " and " + num2 + " is " + b + ".";
	}
	
	public static int gcdR(int a, int b) {
		
		return (a%b != 0 ? b : gcdR(b,a%b));
	} 
	
	public static void main(String[] args) {
		System.out.println(gcd(70, 35));
		
	/*	int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		System.out.println(gcd(a,b));
		System.out.println(gcdR(a,b)); */
		
		//System.out.println("The gcd of " + a + " and " + b + " is " + x + ".");
		//System.out.println("Computed recursively, the gcd is " + b);
		

	}

}
