package org.nick.learn.leetcode.p150;

public class Solution2 {

    static class IntStack {
        int[] arr;
        int index = -1;

        public IntStack(int length) {
            this.arr = new int[length];
        }

        private void push(int value) {
            index = index + 1;
            arr[index] = value;
        }

        private int pop() {
            int result = arr[index];
            index = index - 1;
            return result;
        }
    }


    // 自己实现一个栈
    public int evalRPN(String[] tokens) {
        IntStack stack = new IntStack((tokens.length + 1) / 2);
        for (String token : tokens) {
            if (isOperator(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (token) {
                    case "+" -> stack.push(num1 + num2);
                    case "-" -> stack.push(num1 - num2);
                    case "*" -> stack.push(num1 * num2);
                    case "/" -> stack.push(num1 / num2);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }


    private boolean isOperator(String token) {
        return "+".equals(token)
                || "-".equals(token)
                || "*".equals(token)
                || "/".equals(token);
    }
}
