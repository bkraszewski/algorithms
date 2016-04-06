package com.bartek;

import org.junit.Assert;
import org.junit.Test;

public class SetOfStacksTest {

    @Test
    public void shouldPushAndPopNormally(){
        SetOfStacks<Integer>stack = new SetOfStacks<>(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);

        Assert.assertEquals(1, stack.currentStack);
        Assert.assertEquals(Integer.valueOf(7), stack.pop());
        Assert.assertEquals(Integer.valueOf(6), stack.pop());
        Assert.assertEquals(Integer.valueOf(5), stack.pop());
        Assert.assertEquals(Integer.valueOf(4), stack.pop());
        Assert.assertEquals(Integer.valueOf(3), stack.pop());
        Assert.assertEquals(Integer.valueOf(2), stack.pop());
        Assert.assertEquals(Integer.valueOf(1), stack.pop());
    }
}