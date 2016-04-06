package com.bartek;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Hanoi<T> {

    private List<Stack<T>> stacks = new ArrayList<>(3);

    public Hanoi() {
        stacks.add(new Stack<>());
        stacks.add(new Stack<>());
        stacks.add(new Stack<>());
    }

    public void hanoify() {
        hanoi(first().size(), first(), second(), third());
    }

    public void hanoi(int n, Stack<T> a, Stack<T> b, Stack<T> c) {
        if (n > 0) {
            hanoi(n - 1, a, c, b);
            c.push(a.pop());
            hanoi(n - 1, b, a, c);
        }
    }

    public Stack<T> first() {
        return stacks.get(0);
    }

    public Stack<T> second() {
        return stacks.get(1);
    }

    public Stack<T> third() {
        return stacks.get(2);
    }
}
