package com.bartek;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.bartek.ActivitySelection.*;

public class ActivitySelectionTest {

    @Test
    public void testGreedySelection() {
        List<Activity> activities = createDataset();

        Collection<ActivitySelection.Activity>result = ActivitySelection.chooseMaximumSetRecursive(activities);
        System.out.println(result);

        Assert.assertEquals(4, result.size());
    }

    @Test
    public void testGreedySelectionIterative() {
        List<Activity> activities = createDataset();

        Collection<ActivitySelection.Activity>result = ActivitySelection.chooseMaximumSetIterative(activities);
        System.out.println(result);

        Assert.assertEquals(4, result.size());
    }

    private List<Activity> createDataset() {
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(1, 4));
        activities.add(new Activity(3, 5));
        activities.add(new Activity(0, 6));
        activities.add(new Activity(5, 7));
        activities.add(new Activity(3, 9));
        activities.add(new Activity(5, 9));
        activities.add(new Activity(6, 10));
        activities.add(new Activity(8, 11));
        activities.add(new Activity(8, 12));
        activities.add(new Activity(2, 14));
        activities.add(new Activity(12, 16));
        return activities;
    }

}
