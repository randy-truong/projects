// Name: Randy Truong
// Assignment 1

package Assignment1;


public class NucleotideTest {


    public static void main(String[] args) {

        // Part A and B
        
        // Object declarations
        Nucleotide test1; // for part A&B
        Nucleotide test2; // for part C

        // Creates 1000 codons of random bases and prints the result to the console
        for (int i = 0; i < 1000; i++) {
            test1 = new Nucleotide(3);
            System.out.println(test1.getSequence());
        }


        System.out.println("There are " + Nucleotide.getCount() + " \"AAA\" codons.");
        // For the # of AAA codons, I expect there to be Math.pow(0.25, 3) * 1000 = ~16 codons.
        // The program printed 13-16 codons, which is close to as expected.



        // You can block-comment the below code to only see Part A & B in the console.
        // Part C

        for (int j = 0; j < 1000; j++) {
            test2 = new Nucleotide(3, true);
            System.out.println(test2.getSequence());
        }

        System.out.println("There are " + Nucleotide.getCount2() + " \"AAA\" codons.");
        // With different probabilities, I expect there to be Math.pow(0.12, 3) * 1000 = ~2 codons.
        // The program printed between 1 - 10 codons but closer to 2 - 5 codons, which is more than expected.





    }
}
