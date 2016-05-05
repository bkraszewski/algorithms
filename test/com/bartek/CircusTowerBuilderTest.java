package com.bartek;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CircusTowerBuilderTest {

    @Test
    public void shouldBuildMostOptimalTower() {
        List<CircusTowerBuilder.Person> input = new ArrayList<>();
        input.add(new CircusTowerBuilder.Person(65, 100));
        input.add(new CircusTowerBuilder.Person(70, 150));
        input.add(new CircusTowerBuilder.Person(56, 90));
        input.add(new CircusTowerBuilder.Person(75, 190));
        input.add(new CircusTowerBuilder.Person(60, 95));
        input.add(new CircusTowerBuilder.Person(68, 110));
        List<CircusTowerBuilder.Person> results = CircusTowerBuilder.buildTower(input);

        Assert.assertEquals(new CircusTowerBuilder.Person(56, 90), results.get(0));
        Assert.assertEquals(new CircusTowerBuilder.Person(60, 95), results.get(1));
        Assert.assertEquals(new CircusTowerBuilder.Person(65, 100), results.get(2));
        Assert.assertEquals(new CircusTowerBuilder.Person(68, 110), results.get(3));
        Assert.assertEquals(new CircusTowerBuilder.Person(70, 150), results.get(4));
        Assert.assertEquals(new CircusTowerBuilder.Person(75, 190), results.get(5));
        Assert.assertEquals(6, results.size());



    }
}