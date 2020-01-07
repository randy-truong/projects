//SUBMITTED BY: Randy Truong
//HELPED BY: nobody

public class MagicTrick {

	public static void main(String[] args) {
		
		
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);

		int max1 = Math.max(a, Math.max(b, c));
		int max2 = Math.min(Math.max(Math.min(a, b), c), Math.max(a, b));
		int max3 = Math.min(a, Math.min(b, c));

		int maxAnswer = max1*100 + max2*10 + max3*1;


		int min1 = Math.min(a, Math.min(b, c));
		int min2 = Math.min(Math.max(Math.min(a, b), c), Math.max(a, b));
		int min3 = Math.max(a, Math.max(b, c));
		int minAnswer = min1*100 + min2*10 + min3*1;

		System.out.println("Number: " + maxAnswer);

		System.out.println((maxAnswer + " - " + minAnswer + " = " + (maxAnswer-minAnswer)));
		int x = maxAnswer-minAnswer;
		
		int reverse1 = ((x-x%100)/100);
		int reverse2 = (((x%100)-(x%10))/10);
		int reverse3 = (x%10);
		
		int aRev = Math.min(Math.max(Math.min(reverse1, reverse2), reverse3), Math.min(reverse2, reverse3));
		int bRev = Math.max(reverse1, Math.max(reverse2, reverse3));
		int cRev = Math.min(reverse1, Math.min(reverse2, reverse1));
		int y = aRev*100 + bRev*10 + cRev*1;
		
		/*System.out.println(aRev);
		System.out.println(bRev);
		System.out.println(cRev);*/
		

		//System.out.println(y);
		
		System.out.println(x + " + " + y + " = " + (x+y));


	}

}
