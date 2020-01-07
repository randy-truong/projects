// Name: Randy Truong
// CS 171 Oxford College

package Assignment3;

import java.util.Arrays;

public class SortTest {

    public static void main(String[] args) {
        // Creating random arrays
        int[] oneList = {3, 6, 5, 4};
        int[] anotherList = {6, 9, 2, 7, 1, 8};
        // Calls method to combine two arrays and sort them from smallest to largest
        printElementsInBothArrays(oneList, anotherList);
    }

    private static void printElementsInBothArrays(int[] array1, int[] array2) {
        // Find the combined length of two int arrays
        int length = array1.length + array2.length;
        // Instantiate new int array that is the size of combined arrays
        int[] list = new int[length];

        // Copy the values of the first array into the new list, starting from index 0
        // in the first array into the starting position in the new list at index 0, for
        // the whole length of the first array.
        System.arraycopy(array1, 0, list, 0, array1.length);
        // Repeat with the second array, but starting at the first array's last index
        // until the whole length of the second array.
        System.arraycopy(array2, 0, list, array1.length, array2.length);

        // Bubble Sort method
        for (int k = 1; k < list.length; k++) {
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                }
            }
        }
        // Prints the String representation of the int array
        System.out.println(Arrays.toString(list));
        // Output: [1, 2, 3, 4, 5, 6, 6, 7, 8, 9]
    }

}
