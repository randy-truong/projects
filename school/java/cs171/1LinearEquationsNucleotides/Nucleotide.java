// Name: Randy Truong
// Assignment 1

package Assignment1;

import java.util.Random;

public class Nucleotide {

    // Variables
    Random rand = new Random();
    static int count1 = 0;
    static int count2 = 0;
    private String bases = "ACGT";
    private String randomSeq = "";
    private int length;
    private boolean diffProb;

    // Constructor with 25% frequency and uniform distribution
    Nucleotide(int length) {
        this.length = length;
        char[] sequence = new char[length];

        // Constructs a character array of random nucleotides
        for (int i = 0; i < length; i++) {
            sequence[i] = bases.charAt(rand.nextInt(4));
        }

        // Loops through character array, creating a string
        for (int i = 0; i < sequence.length; i++) {
            this.randomSeq += sequence[i];
        }

        // Counts how many "AAA" codons there are for part A
        if (this.randomSeq.equals("AAA")) {
            count1++;
        }

    }

    // Constructor with different nucleotide frequencies
    Nucleotide(int length, boolean diffProb) {
        this.length = length;
        this.diffProb = diffProb;

        char[] sequence = new char[length];

        // Constructs a character array of specific length of random nucleotides
        for (int i = 0; i < length; i++) {
            // Adds nucleotide to sequence array randomly at varying probabilities.
            // 0.11; 0.11 + 0.12 = 0.23; 0.23 + 0.38 = 0.61; 0.61 + 0.39 = 1
            if (rand.nextInt(100) < 11) {
                sequence[i] = 'T';
            } else if ((rand.nextInt(100) >= 11) && (rand.nextInt(100) < 23)) {
                sequence[i] = 'A';
            } else if ((rand.nextInt(100) >= 23) && (rand.nextInt(100) < 61)) {
                sequence[i] = 'C';
            } else {
                sequence[i] = 'G';
            }

        }

        // Loops through character array, creating a string
        for (int i = 0; i < sequence.length; i++) {
            this.randomSeq += sequence[i];
        }

        // Counts how many "AAA" codons there are for part C
        if (this.randomSeq.equals("AAA")) {
            count2++;
        }

    }

    // Returns random nucleotide sequence
    String getSequence() {
        return this.randomSeq;
    }

    // Returns # of certain codons with 25% equal probability
    static int getCount() {
        return count1;
    }

    // Returns # of certain codons with different probabilities
    static int getCount2() {
        return count2;
    }

}
