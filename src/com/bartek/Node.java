package com.bartek;

import java.util.HashSet;
import java.util.Set;

public class Node<T> {
    public T data;
    private Node<T> next = null;
    private Node<T> head = null;

    public int size = 1;

    public Node(T data) {
        this.data = data;
    }

    public Node() {
    }

    public void addNode(T data) {
        Node node = new Node(data);

        if (head == null) {
            head = node;
            size = 1;
            return;
        }

        Node iter = head;
        while (iter.next != null) {
            iter = iter.next;
        }

        iter.next = node;
        size++;
    }

    public void printValues() {
        Node iter = head;
        while (iter != null) {
            System.out.print(iter.data + ",");
            iter = iter.next;
        }

        System.out.println();
    }

    public void removeLast() {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            size = 0;
            return;
        }

        Node iter = head;

        while (iter.next != null) {
            iter = iter.next;

            if (iter.next != null && iter.next.next == null) {
                iter.next = null;
                size--;
                break;
            }
        }

    }

    public void removeValue(T data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
            size--;
            return;
        }

        Node iter = head;

        while (iter.next != null) {
            if (iter.next.data == data) {
                iter.next = iter.next.next;
                size--;
                return;
            }

            iter = iter.next;
        }
    }

    public void removeDuplicates() {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            return;
        }

        Node<T> iter = head;
        Node<T> prev = null;
        Set<T> cache = new HashSet<>();

        while (iter != null) {
            if (cache.contains(iter.data)) {
                prev.next = iter.next;
                size--;
            } else {
                cache.add(iter.data);
            }

            prev = iter;
            iter = iter.next;
        }
    }
}
