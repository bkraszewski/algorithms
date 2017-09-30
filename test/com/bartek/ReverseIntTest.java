package com.bartek;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseIntTest {


    @Test
    public void easyCases() {
        Assert.assertEquals(1, ReverseInt.reverse(10));
        Assert.assertEquals(123, ReverseInt.reverse(321));
        Assert.assertEquals(1, ReverseInt.reverse(10000));

        Assert.assertEquals(0, ReverseInt.reverse(-1146467285));
    }
}
