package com.bartek;

import org.junit.Assert;
import org.junit.Test;

public class HanoiTest {

    @Test
    public void shouldMoveHanoiTowers() {
        Hanoi<Integer> hanoi = new Hanoi<>();
        hanoi.first().push(5);
        hanoi.first().push(4);
        hanoi.first().push(3);
        hanoi.first().push(2);
        hanoi.first().push(1);

        hanoi.hanoify();
        Assert.assertEquals(0, hanoi.first().size());
        Assert.assertEquals(0, hanoi.second().size());

        Assert.assertEquals(Integer.valueOf(1), hanoi.third().pop());
        Assert.assertEquals(Integer.valueOf(2), hanoi.third().pop());
        Assert.assertEquals(Integer.valueOf(3), hanoi.third().pop());
        Assert.assertEquals(Integer.valueOf(4), hanoi.third().pop());
        Assert.assertEquals(Integer.valueOf(5), hanoi.third().pop());
    }
}