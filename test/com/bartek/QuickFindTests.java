package com.bartek;

import org.junit.Assert;
import org.junit.Test;


public class QuickFindTests {

    @Test
    public void testSimpleConnection() {
        QuickFind find = new QuickFind(10);
        find.connect(0, 1);
        org.junit.Assert.assertTrue(find.isConnected(0, 1));
    }

    @Test
    public void testConnectingCompounds() {
        QuickFind find = new QuickFind(10);
        find.connect(0, 1);
        find.connect(2, 3);
        find.connect(0, 3);
        Assert.assertTrue(find.isConnected(1, 3));
    }

    @Test
    public void testNotConnected() {
        QuickFind find = new QuickFind(10);
        find.connect(0, 1);
        find.connect(2, 3);
        find.connect(0, 3);
        Assert.assertFalse(find.isConnected(1, 9));
    }

    @Test
    public void testSimpleConnectionQuickUnion() {
        QuickUnion find = new QuickUnion(10);
        find.connect(0, 1);
        org.junit.Assert.assertTrue(find.isConnected(0, 1));
    }

    @Test
    public void testConnectingCompoundsQuickUnion() {
        QuickUnion find = new QuickUnion(10);
        find.connect(0, 1);
        find.connect(2, 3);
        find.connect(0, 3);
        Assert.assertTrue(find.isConnected(1, 3));
    }

    @Test
    public void testNotConnectedQuickUnion() {
        QuickUnion find = new QuickUnion(10);
        find.connect(0, 1);
        find.connect(2, 3);
        find.connect(0, 3);
        Assert.assertFalse(find.isConnected(1, 7));
    }

    @Test
    public void testSimpleConnectionWeighted() {
        QuickUnionWeighted find = new QuickUnionWeighted(10);
        find.connect(0, 1);
        org.junit.Assert.assertTrue(find.isConnected(0, 1));
    }

    @Test
    public void testConnectingCompoundsWeigted() {
        QuickUnionWeighted find = new QuickUnionWeighted(10);
        find.connect(0, 1);
        find.connect(2, 3);
        find.connect(0, 3);
        Assert.assertTrue(find.isConnected(1, 3));
    }

    @Test
    public void testNotConnectedWeigted() {
        QuickUnionWeighted find = new QuickUnionWeighted(10);
        find.connect(0, 1);
        find.connect(2, 3);
        find.connect(0, 3);
        Assert.assertFalse(find.isConnected(1, 8));
    }
}
