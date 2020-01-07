//SUBMITTED BY: Randy Truong
//HELPED BY: nobody

public class CartesianToPolar {

	public static void main(String[] args) {
		
		

		
		double x = Double.parseDouble(args[0]);
		double y = Double.parseDouble(args[1]);
		// accepts two values via command line argument
		
				
		
		System.out.printf("r = %.2f, ", Math.hypot(x, y));
		System.out.printf("\u0398 = %.2f\u00B0", Math.toDegrees(Math.atan2(y, x)));
		// first line prints hypotenuse to 2 decimal places '%.2f'
		// second line prints theta (unicode = \u0398) converted from radians to degrees (unicode = \u00B0)
		// prints from cartesian (x, y) to polar coordinates (r, \u0398)




	}

}
