package com.bartek;

import static org.junit.Assert.assertEquals;

public class MyQueueTest {

    @org.junit.Test
    public void shouldWorkAsQueue() {

        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());

        queue.enqueue(4);
        assertEquals(Integer.valueOf(3), queue.dequeue());
        assertEquals(Integer.valueOf(4), queue.dequeue());

    }
}