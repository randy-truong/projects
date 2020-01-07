//SUBMITTED BY: Randy Truong
//HELPED BY: nobody


import java.util.Arrays;




public class Matrix {
	private double[][] array;
	int count = 0;
	

	Matrix(double[][] array) {
		this.array = array;
		
	}
	
	Matrix() {
		for (int i = 0; i < this.array.length; i++) {
			for (int j = 0; j < this.array[i].length; j++) {
				double[][] array = new double[this.array.length][this.array[i].length];
				array[i][j] = 0.0;
			}
		}
	}
	
	public String toString() {
		
		
		for (int i = 0; i < this.array.length; i++) {
			for (int j = 0; j < this.array[i].length; j++) {
				
				System.out.print(this.array[i][j] + "\t" + "\n");
				
				}
				
			}
		return "\n";
		//return this.array[i][j] + "\t";


	}
	
	public int numRows() {
		for (int i = 0; i < this.array.length; i++) {
			count++;
			
			}
		return count;
		
	}
	
	public int numCols() {
		for (int i = 0; i < this.array.length; i++) {
			for (int j = 0; j < this.array[i].length; j++) {
				count++;
			}
		}
		return count/(this.array.length);
	}

	public double getElement(int r, int c) {
		return this.array[r][c];
		}


	
	public void setElement(int r, int c, double value) {
		this.array[r][c] = value;
		} 
	
	public void sum(double[][] a, double[][] b) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				double[][] sumArray = new double[i][j];
				sumArray[i][j] = a[i][j] + b[i][j];

			}
		}


	}
	
	
	public void product(double[][] a, double[][] b) {
	
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				double[][] productArray = new double[i][j];
				productArray[i][j] = a[i][j] * b[i][j];
			}
		}

				
	} 
	
	public double[][] subMatrix(int deletedRow, int deletedCol) {
		//double[][] subArray = Arrays.copyOfRange(this.array, deletedRow, deletedCol);
		double[][] subArray = new double[deletedRow + 1][deletedCol + 1];
		for (int i = 0; i < subArray.length; i++) {
			for (int j = 0; j < subArray[i].length; j++) {
				if (this.array.length <= 1 || this.array[i].length <= 1)
					return null;
			}
		}
		return subArray;

	}

	
/*	public double determinant(double[][] a) {
		for (int i = 0; i < a.length; i++) {
		return (a.length != a[i].length ? null : -i * determinant(subMatrix(0, i)));
		}
	
	} */
	
}
