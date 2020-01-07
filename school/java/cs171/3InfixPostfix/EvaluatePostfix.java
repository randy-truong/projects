// Name: Randy Truong
// CS 171 Oxford College

package Assignment3;

import java.util.Stack;

public class EvaluatePostfix {

    public static void main(String[] args) {
        // Postfix equation as follows:
        String test = "( ( 2 3 * ) ( 4 2 + ) / )";
        // Postfix evaluation
        System.out.println(evaluatePostfix(test));
        // Output: 1; since infix equation is ( ( 2 * 3 ) / ( 4 + 2 ) ) = 1, then 1 = 1 is true
    }

    private static int evaluatePostfix(String postfixExpression) {
        Stack<String> operands = new Stack<>();
        Stack<String> operators = new Stack<>();
        String[] values = postfixExpression.split("\\s");

        //Fill in your code here....
        for (int i = 0; i < values.length; i++) {
            // Referencing Djikstra's two-stack algorithm:
            // If operand, push onto operand stack
            // If operator, push onto operator stack
            // If left parenthesis, ignore
            // If right parenthesis, pop operator & two values; push result of the two

            if (values[i].equals("(")) {
                // Ignore left parenthesis
                continue;
            }
            else if (values[i].equals("+") || values[i].equals("-") || values[i].equals("/") || values[i].equals("*")) {
                // Operator detected, pushing into operator stack
                operators.push(values[i]);
            }
            else if (values[i].equals(")")) {
                // Right parenthesis detected, pop operator, pop two values, push its result
                // Note: given stack |2||3||4| (read left->right, left being the bottom), popping out the first
                // two results in |2|| || | where they are temporarily held as |4||3|,
                // therefore when finding the result, the order of the values matters!
                int result = 0;
                String operator = operators.pop();
                int firstValue = Integer.parseInt(operands.pop());
                int secondValue = Integer.parseInt(operands.pop());

                // If the popped operator is a "+" then add the two popped operands
                if (operator.equals("+")) {
                    result = secondValue + firstValue;
                }
                // If the popped operator is a "-" then subtract the two popped operands
                else if (operator.equals("-")) {
                    result = secondValue - firstValue;
                }
                // If the popped operator is a "/" then divide the two popped operands
                else if (operator.equals("/")) {
                    result = secondValue * firstValue;
                }
                // If the popped operator is a "*" then divide the two popped operands
                else if (operator.equals("*")) {
                    result = secondValue / firstValue;
                }
                // Push the result back into operands stack
                // And since the stack is of String type, then
                // we must convert the Integer type result into a String
                operands.push(String.valueOf(result));
            }
            else {
                // Digits detected, pushing into operand stack
                operands.push(values[i]);
            }
            // For loop repeats process until all numbers have been accounted for
        }

        // Returns Integer final result of the operands stack
        // We must parseInt because the operands stack is of String type
        // and the method returns an integer
        return Integer.parseInt(operands.pop());
    }
}
