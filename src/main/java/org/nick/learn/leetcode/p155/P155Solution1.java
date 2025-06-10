package org.nick.learn.leetcode.p155;

import java.util.ArrayDeque;
import java.util.Deque;

public class P155Solution1 {

    class MinStack {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();

        public MinStack() {

        }

        public void push(int val) {
            stack1.push(val);
            if (stack2.isEmpty()) {
                stack2.push(val);
            } else {
                stack2.push(Math.min(stack2.peek(), val));
            }
        }

        public void pop() {
            stack1.pop();
            stack2.pop();
        }

        public int top() {
            if (stack1.isEmpty()) {
                throw new NullPointerException();
            }
            return stack1.peek();
        }

        public int getMin() {
            if (stack2.isEmpty()) {
                throw new NullPointerException();
            }
            return stack2.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
