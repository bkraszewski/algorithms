package com.bartek;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class SetOfStacks<T> extends Stack<T> {
    private final int stackSizeLimit;

    public int currentStack = 0;
    private List<Stack<T>> stacks = new ArrayList<>();

    public SetOfStacks(int stackSizeLimit) {
        this.stackSizeLimit = stackSizeLimit;
        //TODO can be lazy inited when needed
        stacks.add(new Stack<T>());
    }

    @Override
    public T push(T item) {
        Stack<T> current = stacks.get(currentStack);
        if (current.size() == stackSizeLimit) {
            current = new Stack<>();
            stacks.add(current);
            currentStack++;
        }

        current.push(item);
        return item;
    }

    @Override
    public synchronized T pop() {
        Stack<T> current = stacks.get(currentStack);

        if (current.isEmpty()) {
            if (currentStack == 0) {
                throw new EmptyStackException();
            }

            stacks.remove(currentStack--);
            current = stacks.get(currentStack);
        }

        return current.pop();
    }
}
