//SUBMITTED BY: Randy Truong
//HELPED BY: nobody


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FunFactDisplayer {

	public static void main(String[] args) throws FileNotFoundException {
		
		
		// Mac users should use /Users/<username>/Desktop/<folder>/
		String filepath = args[0];
		

		// prompts user for response
		Scanner scanner = new Scanner(System.in);
		System.out.print("What's your name? ");
		String name = scanner.nextLine();
		System.out.print("Pick a year: (1886, 1928, or 1969) ");
		String year = scanner.nextLine();
		
		
		// finds .txt file and reads it
		File file = new File(filepath, year + ".txt");
		scanner = new Scanner(file);
		String line = scanner.nextLine();

		scanner.close();
		
		JOptionPane.showMessageDialog(null, "In " + year + ", " + line, name + ", did you know...", JOptionPane.INFORMATION_MESSAGE);
		
		
		// prompts user for a fact
		Scanner question = new Scanner(System.in);
		System.out.print("Your turn - tell me a fun fact about this year. ");
		String fact = question.nextLine();
		question.close();
		
		File relay = new File(filepath + "2018.txt/");
		PrintWriter fileWriter = new PrintWriter(relay);
		fileWriter.print(fact);
		fileWriter.close();
		// creates .txt file with user's fact
		
		
		System.out.println("I recorded your fun fact in a file named \"2018.txt\"");
		
	
        
		
	}

}
