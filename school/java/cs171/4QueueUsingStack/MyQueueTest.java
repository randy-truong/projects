// Name: Randy Truong
// CS 171 Oxford College

package Assignment4;

public class MyQueueTest {
    public static void main(String[] args) {

        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);

        System.out.println(queue.peek()); // called method returns 1, prints 1 to console
        System.out.println(queue.pop()); // called method returns 1, prints 1 to console
        System.out.println(queue.empty()); // called method returns false, prints false to console

        // More testing!
        // After pushing in two values and popping one, we should
        // be able to push in more to the end of the queue-stack, and
        // still be able to pop out the values "first-in-first-out" order
        // as shown below!

        // adds 3, 4, 5 to the back of the queue
        queue.push(3);
        queue.push(4);
        queue.push(5);

        System.out.println(queue.peek()); // called method returns 2, prints 2 to console
        System.out.println(queue.pop()); // called method returns 2, prints 2 to console

        System.out.println(queue.peek()); // called method returns 3, prints 3 to console
        System.out.println(queue.pop()); // called method returns 3, prints 3 to console
        System.out.println(queue.peek()); // called method returns 4, prints 4 to console
        System.out.println(queue.pop()); // called method returns 4, prints 4 to console

        // adds 6 to the back of queue
        queue.push(6);
        System.out.println(queue.peek()); // called method returns 5, prints 5 to console
        System.out.println(queue.pop()); // called method returns 5, prints 5 to console
        System.out.println(queue.peek()); // called method returns 6, prints 6 to console
        System.out.println(queue.pop()); // called method returns 6, prints 6 to console

        System.out.println(queue.empty()); // called method returns true, prints true to console

    }
}
