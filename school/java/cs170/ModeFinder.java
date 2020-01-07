//SUBMITTED BY: Randy Truong
//HELPED BY: nobody

import java.util.Arrays;
import java.util.Scanner;

public class ModeFinder {

	
	// I apologize! I really tried and could not figure this one out.
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		System.out.println();
		int[] array = new int[input.nextInt()];
		int[] numArray;
		
		System.out.print("Enter some number of integers, separated by spaces: ");
		for (int i = 0; i < array.length; i++) {
			array[i] = input.nextInt();
			numArray = new int[array.length];
		}
		
		int modeNum = 0;
		int count = 0;
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (array[j] == array[i]) {
					count++;
					modeNum = array[i];
				}
			}

		}

			
		System.out.println(count == 1 ? "There was 1 mode: \n" + modeNum : "There were " + count + " modes: \n" + array);
		}
	
		

	

}
