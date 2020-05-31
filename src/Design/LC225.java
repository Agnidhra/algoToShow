package Design;

import java.util.LinkedList;
import java.util.Queue;

/*

225. Implement Stack using Queues

Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Example:

MyStack stack = new MyStack();

stack.push(1);
stack.push(2);
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
Notes:

You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).

*/

public class LC225 {
        Queue<Integer> fq;
        Queue<Integer> sq;

        /** Initialize your data structure here. */
        //public MyStack() {
         public LC225() {
            fq = new LinkedList<Integer>();
            sq = new LinkedList<Integer>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if(fq.isEmpty()) {
                fq.add(x);
                while(!sq.isEmpty()) {
                    fq.add(sq.poll());
                }
            } else {
                sq.add(x);
                while(!fq.isEmpty()) {
                    sq.add(fq.poll());
                }
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if(fq.isEmpty()) {
                return sq.poll();
            } else {
                return fq.poll();
            }
        }

        /** Get the top element. */
        public int top() {
            if(fq.isEmpty()) {
                return sq.peek();
            } else {
                return fq.peek();
            }
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return fq.isEmpty() && sq.isEmpty();
        }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */