//SUBMITTED BY: Randy Truong
//HELPED BY: Andrew Yin



public class BaseChange {

	public static void main(String[] args) {
		
		int decimalInt = Integer.parseInt(args[0]);
		int base = Integer.parseInt(args[1]);
		
		String baseStr = " ";
		int quotient = decimalInt/base;


		
		while (quotient != 0) {

			int remainder = decimalInt % base;
			
			if (quotient != 0) {
				if (remainder <= 9)
					baseStr = remainder + baseStr;

				else if (remainder > 9 && remainder <= 36) {
					char letter = (char) (remainder + 55);
					baseStr = letter + baseStr;
					} 
			else {
				baseStr = " " + baseStr;
				baseStr = remainder + baseStr;
				baseStr = " " + baseStr;
					}
				}

				quotient = decimalInt/base;
				decimalInt = quotient;

			}

			System.out.print(baseStr);

	}

}
