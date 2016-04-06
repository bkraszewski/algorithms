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

    @Test
    public void shouldRemoveMiddleElementWithoutAccessToHead(){
        Node<Integer>node = createLinkedList();
        Node<Integer> middle = node.rewind(2);

        node.printValues();
        //delete node with value 4
        middle.deleteCurrent();
        node.printValues();


    }

    @Test
    public void shouldSplitArrayByValue(){
        Node<Integer>node = createLinkedList();
        node.splitBy(4);
        node.printValues();
    }

    @Test
    public void shouldSplitArrayByValueUsingTwoLists(){
        Node<Integer>node = createLinkedList();
        Node<Integer> splited = node.splitByUsingTwoLists(4);
        splited.printValues();
    }

    @Test
    public void shouldAddNumbersOnLinkedLists(){
        Node<Integer>first = new Node<>();
        first.addNode(7);
        first.addNode(1);
        first.addNode(6);
        first.addNode(9);

        Node<Integer>second = new Node<>();
        second.addNode(5);
        second.addNode(9);
        second.addNode(2);

        Node<Integer>result = first.addNumbers(second.head);
        result.printValues();
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
