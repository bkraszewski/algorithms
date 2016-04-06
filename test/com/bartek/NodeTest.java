package com.bartek;

import org.junit.Assert;
import org.junit.Test;

public class NodeTest {

    @Test
    public void testNodes() {
        Node<Integer> node = new Node<>();
        node.addNode(3);
        node.addNode(4);
        node.addNode(5);
        node.addNode(6);

        node.printValues();
        Assert.assertEquals(4, node.size);

        node.removeLast();
        node.printValues();
        Assert.assertEquals(3, node.size);

        node.addNode(6);
        node.printValues();
        Assert.assertEquals(4, node.size);

        node.removeValue(6);
        node.printValues();
        Assert.assertEquals(3, node.size);

        node.addNode(6);
        node.removeValue(3);
        node.printValues();
        Assert.assertEquals(3, node.size);

    }

    @Test
    public void shouldRemoveDuplicates() {
        Node<Integer> node = new Node<>();
        node.addNode(3);
        node.addNode(3);
        node.addNode(4);
        node.addNode(5);
        node.addNode(4);
        node.addNode(3);

        node.removeDuplicates();
        node.printValues();
        Assert.assertEquals(3, node.size);
    }

    @Test
    public void shouldFindKthElementFromEnd() {
        Node<Integer> node = createLinkedList();

        Assert.assertEquals(Integer.valueOf(4), node.getItemFromEnd(4));
        Assert.assertEquals(Integer.valueOf(10), node.getItemFromEnd(0));
        Assert.assertEquals(Integer.valueOf(3), node.getItemFromEnd(8));

    }

    @Test
    public void shouldFindKthElementFromEndRecursive() {
        Node<Integer> node = createLinkedList();

        Assert.assertEquals(Integer.valueOf(4), node.getItemFromEndRecursive(4));
        Assert.assertEquals(Integer.valueOf(10), node.getItemFromEndRecursive(0));
        Assert.assertEquals(Integer.valueOf(3), node.getItemFromEndRecursive(8));

    }

    private Node<Integer> createLinkedList() {
        Node<Integer> node = new Node<>();
        node.addNode(3);
        node.addNode(3);
        node.addNode(4);
        node.addNode(5);
        node.addNode(4);
        node.addNode(3);
        node.addNode(8);
        node.addNode(9);
        node.addNode(10);
        return node;
    }
}
