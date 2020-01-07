//SUBMITTED BY: Randy Truong
//HELPED BY: nobody


public class IntegerMethods {
	
	public static void main(String[] args) {
		

		System.out.println(sumOfDigits(535));
		System.out.println(reverse(892));
		System.out.println(isPalindrome(1331));
		System.out.println(decreasingDigits(5, 3, 9));
		//System.out.println(magicTrick(5, 3, 9));
		System.out.println(isPrime(2));
		System.out.println(round(5));
		System.out.println(decreasingDigits(5, 9, 3));
		//System.out.println(reverse(decreasingDigits(5, 9, 3)));
		System.out.println(magicTrick(7, 8, 9));
		//magicTrick(decreasingDigits(a, b, c));
		
		System.out.println(collatz(3));
		//System.out.println(round(2));

	}
	
	public static int sumOfDigits(int a) {
		int sum = 0;
		while (a != 0) {
			sum = sum + (a % 10);
			a = a/10;
			
		} return sum;
	}
	
	public static int reverse(int a) {
		int isolatedNum = 0;
		while (a != 0) {
			isolatedNum = (isolatedNum*10) + (a % 10);
			a = a/10;
			
		} return isolatedNum;
	}
	
	public static boolean isPalindrome(int a) {
		return (a == reverse(a) ? true : false);

	}
	
	public static boolean isPrime(int a) {
	
		for (int i = 2; i < a; i++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}
	

	public static int round(double a) {
	
		for (int i = 0; i < a; i++) {
			if (a == (int) a) {
				System.out.println("Row, row, row your boat...");
			}
			
		}
		return (int) (a + 0.5);
		
		
	}
	
	public static int decreasingDigits(int a, int b, int c) {
		int max1 = Math.max(a, Math.max(b, c));
		int max2 = Math.min(Math.max(Math.min(a, b), c), Math.max(a, b));
		int max3 = Math.min(a, Math.min(b, c));
		return (max1*100 + max2*10 + max3*1);
		
		
	}
	
	public static String magicTrick(int a, int b, int c) {

		int num1 = decreasingDigits(a, b, c);
		int num2 = reverse(decreasingDigits(a,b ,c));
		int difference1 = num1 - num2;
		int num3 = reverse(difference1);
		int sum1 = difference1 + num3;
		return ("Number: " + num1 + "\n" + num1 + " - " + num2 + " = " + difference1
				+ "\n" + difference1 + " + " + num3 + " = " + sum1);
		//return reverse(decreasingDigits(a, b, c));
	}
	
	public static String collatz(int a) {
		int i = 0;
		//System.out.println(a);
		do {
			if (a % 2 == 0) {
				a = a / 2;
				//System.out.println(a);
				//i++;
			}
			else 
				a = (a*3) + 1;
				System.out.println(a);
				i++;
			} while (a != 1);
		//System.out.println("Total steps: " + i);
		return "Total steps: " + i;
	}

}
