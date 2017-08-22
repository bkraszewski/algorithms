package com.bartek;

import javax.swing.event.ListDataEvent;

public  class LinkedNodeTest {
    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode deleteDuplicates(ListNode a) {
        ListNode current = a;

        while (current != null) {
            ListNode next = current.next;
            if (next != null) {
                while(next != null && current.val == next.val){
                    next = next.next;
                }
                current.next = next;
            }
            current = current.next;
        }

        return a;
    }

    public static void main(String[] args){
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);

        node.next = node2;
        node2.next = node3;
        deleteDuplicates(node);
    }
}
