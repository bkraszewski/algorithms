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
    public void shouldRemoveDuplicates(){
        Node<Integer>node = new Node<>();
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
}
