package com.bartek;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Node<T> {
    public T data;
    private Node<T> next = null;
    public Node head = null;

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
        Node iter = this;
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

    public T getItemFromEnd(int indexFromExit) {
        int index = 0;
        Map<Integer, T> map = new HashMap<>();

        Node<T> iter = head;
        while (iter != null) {
            map.put(index++, iter.data);
            iter = iter.next;
        }

        if (index - indexFromExit - 1 >= 0) {
            return map.get(index - indexFromExit - 1);
        }

        throw new IllegalArgumentException("Not enought elements in list");
    }

    public T getItemFromEndRecursive(int indexFromEnd) {
        Node<T> data = scanIter(head, indexFromEnd, new IntWrapper());
        return data.data;
    }

    private Node<T> scanIter(Node<T> iter, int n, IntWrapper wrapper) {
        if (iter == null) {
            return null;
        }

        Node<T> node = scanIter(iter.next, n, wrapper);
        wrapper.index++;
        if (wrapper.index == n) {
            return iter;
        }

        return node;
    }

    public Node<T> rewind(int howMany) {
        Node<T> iter = head;
        for (int i = 0; i < howMany; i++) {
            if (iter.next != null) {
                iter = iter.next;
            }
        }

        return iter;
    }

    public void deleteCurrent() {
        if (next == null) {
            //dont work if its last element
            return;
        }

        this.data = next.data;
        this.next = next.next;
        size--;
    }

    public void splitBy(Integer k) {
        Node<Integer> n = head;

        while (n != null) {
            if (n.data > k) {
                //swap all future smaller with me
                swapNextSmaller(n, k);
            } else {
                //its ok, do nothing
            }

            n = n.next;
        }
    }

    private void swapNextSmaller(Node<Integer> n, Integer k) {
        Node<Integer> iter = n;
        while (iter.next != null) {
            iter = iter.next;

            if (iter.data < k) {
                //swap with first
                Integer data = n.data;
                n.data = iter.data;
                iter.data = data;
            }
        }
    }

    public Node splitByUsingTwoLists(Integer k) {
        Node<Integer> smallerHead = null;
        Node<Integer> smallerTail = null;

        Node<Integer> biggerHead = null;
        Node<Integer> biggerTail = null;

        Node<Integer> iter = head;
        while (iter != null) {

            Node next = iter.next;
            iter.next = null;
            if (iter.data < k) {
                //add to smaller list
                if (smallerHead == null) {
                    smallerHead = iter;
                    smallerTail = iter;
                } else {
                    smallerTail.next = iter;
                    smallerTail = iter;
                }
            } else {
                if (biggerHead == null) {
                    biggerHead = iter;
                    biggerTail = iter;
                } else {
                    biggerTail.next = iter;
                    biggerTail = iter;
                }
            }

            iter = next;

        }

        //merge two lists;

        Node<Integer> returnedList = null;
        if (smallerHead != null) {
            returnedList = smallerHead;
        } else {
            returnedList = biggerHead;
            return returnedList;
        }

        if (biggerTail != null) {
            smallerTail.next = biggerHead;
        }

        return returnedList;
    }

    public Node<Integer> addNumbers(Node<Integer> node) {
        if (node == null) {
            throw new IllegalArgumentException("Cant pass null");
        }

        Node<Integer> first = head;
        Node<Integer> second = node;
        Node<Integer> result = new Node<>();
        int offset = 0;

        while (first != null || second != null) {
            if (first == null) {
                offset = saveAddResultWithOffset(0, second.data, offset, result);
            } else if (second == null) {
                offset = saveAddResultWithOffset(first.data, 0, offset, result);
            } else {
                offset = saveAddResultWithOffset(first.data, second.data, offset, result);
            }

            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }

        if (offset > 0) {
            result.addNode(offset);
        }

        return result.head;

    }

    private int saveAddResultWithOffset(int first, int second, int offset, Node<Integer> result) {
        int value = first + second + offset;
        result.addNode(value < 10 ? value : value % 10);
        return value / 10;
    }

    private class IntWrapper {
        int index = -1;
    }
}
