package labWeek5;
import java.util.Random;

//SUBMITTED BY: Randy Truong
//HELPED BY: Tracy Hu
//HELPED BY: Nicole Pan
//HELPED BY: Ender Schmidt



public class MethodMadness {
	
	
	
static Random r = new Random();
	
	public static void main(String[] args) {

		boolean b = isLeapYear(Integer.parseInt(args[0]));
		parrot(getGrade(Double.parseDouble(args[1])));
		double x = Double.parseDouble(args[2]);
		double y = Double.parseDouble(args[3]);
		System.out.printf("r = %.2f, \u03B8 = %.2f\u00B0\n", distToOrigin(x, y), angleFromCartesian(x,y));
		if (b)
			System.out.println(productFinder(r.nextInt(10), r.nextInt(10), r.nextInt(10)));
		
	}
	
	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			return trsue;
		else return false;
	}
	
	public static int productFinder(int a, int b, int c) {
		return a*b*c;
	}
	
	public static void parrot(String s) {
		System.out.println(s + ", Squawk!");
	}
	
	public static String getGrade(double score) {
		
		if (score >= 90)
			return "A";
		else if (score >= 80)
			return "B";
		else if (score >= 70)
			return "C";
		else if (score >= 60)
			return "D";
		else
			return "F";
		
	}

	public static double distToOrigin(double x, double y) {
		return Math.sqrt(x*x + y*y);
	}
	
	public static double angleFromCartesian(double x, double y) {
		return Math.atan2(y, x)*180/Math.PI;
	}
	
}
