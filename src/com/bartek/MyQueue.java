package com.bartek;

import java.util.Stack;

public class MyQueue<T> {

    private Stack<T> data = new Stack<>();
    private Stack<T> buffer = new Stack<>();

    public void enqueue(T item) {
        moveDataToBuffer();
        data.push(item);
        getDataFromBuffer();
    }

    private void getDataFromBuffer() {
        while (!buffer.isEmpty()) {
            data.push(buffer.pop());
        }
    }

    private void moveDataToBuffer() {
        while (!data.isEmpty()) {
            buffer.push(data.pop());
        }
    }

    public T dequeue() {
        return data.pop();
    }
}
