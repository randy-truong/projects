// Name: Randy Truong
// CS 171 Oxford College

package Assignment4;

import java.util.Stack;

public class MyQueue {

    // Variables
    // stack1 and stack2 are for popping
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    // stack3 and stack4 are for peeking
    private Stack<Integer> stack3 = new Stack<>();
    private Stack<Integer> stack4 = new Stack<>();

    private int peekValue;

    // Empty constructor
    public MyQueue() {}

    // Pushes element x to the back of the queue
    public void push(int x) {

        // Conditionals: if the reversed stack [2] is not empty, move the elements
        // in the reversed stack [2] (i.e. stack1: (B)|1|2|(T) -> stack2: (B)|2|1|(T) )
        // to the temporary stack [1]
        if (stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
        if (stack4.size() > 0) {
            stack3.push(stack4.pop());
        }

        // Adds element x to the top of the stack
        stack1.push(x);
        stack3.push(x);

        // Result: maintains natural order of a queue ("first-in-first-out") if we
        // pushed in two elements, popped one of those two elements, pushed in two more elements,
        // and popped out the remaining elements in order of a queue.

    }

    // Removes the element from the front of the queue and returns that element
    public int pop() {
        // Conditional: while stack1 (temporary) is not empty, push elements to stack2,
        // therefore reversing the order to be a queue.
        // i.e. stack1: (B)|1|2|3|(T) -> stack2: (B)|3|2|1|(T)
        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }
        // Removes and returns the top element from the queue-stack
        return stack2.pop();
    }

    // Gets the front element
    public int peek() {
        // Conditional: while stack1 (temporary) is not empty, push elements to stack2,
        // therefore reversing the order to be a queue.
        // i.e. stack3: (B)|1|2|3|(T) -> stack4: (B)|3|2|1|(T)
        while (stack3.size() > 0) {
            stack4.push(stack3.pop());
        }
        // Gets the front element
        peekValue = stack4.peek();
        // Removes the front element
        stack4.pop();

        // Returns the front element from the queue-stack
        return peekValue;
    }

    // Returns whether the queue is empty
    public boolean empty() {
        return stack2.isEmpty();
    }
}
