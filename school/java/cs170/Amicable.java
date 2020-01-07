//SUBMITTED BY: Randy Truong
//HELPED BY: nobody



public class Amicable {

	public static void main(String[] args) {
		
		int posA = Integer.parseInt(args[0]);
		int posB = Integer.parseInt(args[1]);

		int sumAmicableA = 0;
		int sumAmicableB = 0;

		for (int n = 1; posA%n == 0; n++) {
			sumAmicableA += n;
			}
		
		for (int m = 1; posB%m == 0; m++) {
			sumAmicableB += m;
			}
		
	
		if (sumAmicableA == sumAmicableB) {
			System.out.println(posA + " and " + posB + " are amicable numbers");
			}
		else {
			System.out.println(posA + " and " + posB + " are not amicable numbers");
			}
		
		
		

	}

}
