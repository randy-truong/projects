import java.util.Random;

//SUBMITTED BY: Randy Truong
//HELPED BY: Tracy Hu
//HELPED BY: Nicole Pan
//HELPED BY: Ender Schmidt



public class ArrayTasks {

	static Random r = new Random();
	
	public static int max(int[] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}
	
	public static int countGreaterThan10(int[] a) {
		int numSeen = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 10) {
				numSeen++;
			}
		}
		return numSeen;
	}
	
	public static double average(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return 1.0 * sum / a.length;
	}

	public static int maxIndex(int[] a) {
		int max = a[0];
		int indexOfMax = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
				indexOfMax = i;
			}
		}
		return indexOfMax;
	}
	
	public static int[] randomArray(int length) {
		int[] result = new int[length];
		for (int i = 0; i < length; i++)
			result[i] = r.nextInt(20) + 1;
		return result;
	}
	
	public static void printIntArray(int[] a) {
		// Arrays can be queried for their length
		for (int i = 0; i < a.length; i++) { 
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		int[] myArray = randomArray(10);
		printIntArray(myArray);
		System.out.println("The max is " + max(myArray));
		System.out.println("The average is " + average(myArray));
		System.out.println("There are " + countGreaterThan10(myArray) + " elements bigger than 10.");
		exchange(myArray, 0, maxIndex(myArray));
		printIntArray(myArray);
		
	}
	
	public static void exchange(int[] a, int i, int j) { 
		// Swap contents at positions i, j
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
