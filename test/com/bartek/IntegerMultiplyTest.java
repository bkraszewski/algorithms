package com.bartek;

import com.bartek.coursera.IntegerMultiply;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class IntegerMultiplyTest {

    @Test
    public void shouldReturnFour() {
        System.out.println(IntegerMultiply
                .multiply(new BigDecimal("3141592653589793238462643383279502884197169399375105820974944592"),
                        new BigDecimal("2718281828459045235360287471352662497757247093699959574966967627")));
        Assert.assertEquals("4", IntegerMultiply.multiply(BigDecimal.valueOf(2), BigDecimal.valueOf(2)).toString());
    }
}
