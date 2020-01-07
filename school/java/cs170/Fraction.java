//SUBMITTED BY: Randy Truong
//HELPED BY: Tracy Hu
//HELPED BY: Nicole Pan
//HELPED BY: Ender Schmidt




public class Fraction {

	int numerator;
	int denominator;

	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		
	}


	
	public int getNumerator() {
		return this.numerator;
	}
	public int getDenominator() {
		return this.denominator;
	}
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
	public int getFraction() {
		return this.numerator / this.denominator;
	}
	
	public int Reciprocal() {
		return this.denominator / this.numerator;
		
	}
	
	public int multiplyFraction(int numerator1, int denominator1, int numerator2, int denominator2) {
		//return Fraction1 * Fraction2
		
	//	this.numerator = numerator1;
	//	this.denominator = denominator1;
		double firstFraction = numerator1 / denominator1;
		
	//	this.numerator = numerator2;
	//	this.numerator = denominator2;
		double secondFraction = numerator2 / denominator2;
		
		return (int) (firstFraction * secondFraction);
		
	}
	
	public int divideFraction(int numerator1, int denominator1, int numerator2, int denominator2) {
		//return Fraction1 * reciprocalFraction2
		double firstFraction = numerator1 / denominator1;
		double secondFraction = denominator2 / numerator2;
		
		return (int) (firstFraction * secondFraction);
		
		
		
		
	}
	
	public String toFractionString() {
		return this.numerator + "/" + this.denominator;
	}
	
	
	private boolean isItEqual() {
		//return (fraction1 == fraction2 ? true : false);
	}
}
