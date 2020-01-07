// Name: Randy Truong
// CS 171 Oxford College

package Assignment3;

import java.util.Stack;

public class InfixPostfix {

    public static void main(String[] args) {

        // In order to successfully run the program, infix equations must have spaces between each
        // character, digit, or operator, as the method splits the given String into a String array
        // containing each character of the String, and it is split according the spaces between.

        // Infix equation as follows:
        String test = "( ( 2 * 3 ) / ( 4 + 2 ) )";
        // Postfix equation as follows:
        System.out.println(infixToPostfix(test));
        // Output: 2 3 * 4 2 + /


        // Infix equation as follows:
        String anotherTest = " ( 6 + 7 )";
        // Postfix equations as follows:
        System.out.println(infixToPostfix(anotherTest));
        // Output: 6 7 +
    }

    private static String infixToPostfix(String infixExpression) {
        Stack<String> operands = new Stack<>();
        Stack<String> operators = new Stack<>();
        String[] inputValues = infixExpression.split("\\s");

        //Fill in your code here ....
        for (int i = 0; i < inputValues.length; i++) {
            // Referencing Djikstra's two-stack algorithm:
            // If operand, push onto operand stack
            // If operator, push onto operator stack
            // If left parenthesis, ignore
            // If right parenthesis, pop operator & two values; push result of the two

            if (inputValues[i].equals("(")) {
                // Ignore left parenthesis
                continue;
            }
            else if (inputValues[i].equals("+") || inputValues[i].equals("-") ||inputValues[i].equals("/") || inputValues[i].equals("*")) {
                // Operator detected, pushing into operator stack
                operators.push(inputValues[i]);
            }
            else if (inputValues[i].equals(")")) {
                // Right parenthesis detected, pop operator, pop two values, push its result
                // Note: given stack |2||3||4| (read left->right, left being the bottom), popping out the first
                // two results in |2|| || | where they are temporarily held as |4||3|,
                // therefore when finding the result, the order of the values matters!
                String operator = operators.pop();
                String firstValue = operands.pop();
                String secondValue = operands.pop();

                operands.push(secondValue + " " + firstValue + " " + operator);
            }
            else {
                // Digits detected, pushing into operand stack
                operands.push(inputValues[i]);
            }
            // For loop repeats process until all numbers have been accounted for
        }
        // Returns the String representation of the infix -> postfix equation
        return operands.pop();
    }
}
