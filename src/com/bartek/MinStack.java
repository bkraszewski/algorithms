package com.bartek;

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int mIndex;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        mIndex = -1;
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty())
            minStack.push(x);
        else if (x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        int num = stack.pop();
        if (num == minStack.peek())
            minStack.pop();
    }

    public int top() {
        if (stack.isEmpty())
            return -1;

        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty())
            return -1;

        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.getMin());
        stack.pop();

        System.out.println(stack.getMin());
        stack.pop();

        System.out.println(stack.getMin());
        stack.pop();
    }


}
