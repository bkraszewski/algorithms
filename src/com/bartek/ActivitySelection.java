package com.bartek;

import java.util.ArrayList;
import java.util.List;

public class ActivitySelection {
    public static List<Activity> chooseMaximumSetRecursive(List<Activity> activities) {
        sort(activities);
        List<Activity> result = recursiveActivitySelector(activities, 0, activities.size(), new ArrayList<>());
        return result;
    }

    private static void sort(List<Activity> activities) {
        activities.sort((o1, o2) -> o1.finish - o2.start);
    }

    private static List<Activity> recursiveActivitySelector(List<Activity> activities, int k, int n, ArrayList<Activity> result) {
        if (k == 0) {
            result.add(activities.get(k));
        }

        int m = k + 1;
        while (m < n && activities.get(m).start < activities.get(k).finish) {
            m++;
        }

        if (m < n) {
            result.add(activities.get(m));
            return recursiveActivitySelector(activities, m, n, result);
        }

        return result;
    }

    public static List<Activity> chooseMaximumSetIterative(List<Activity> activities) {
        sort(activities);
        int n = activities.size();
        int k = 0;

        List<Activity> result = new ArrayList<>();
        result.add(activities.get(k));

        for (int m = 1; m < n; m++) {
            if (activities.get(k).finish < activities.get(m).start) {
                k = m;
                result.add(activities.get(m));
            }
        }

        return result;
    }

    public static int calculateNumberOfLectureHalls(List<Activity> activities) {
        int count = 0;
        while (!activities.isEmpty()) {
            List<Activity> results = chooseMaximumSetIterative(activities);
            activities.removeAll(results);
            count++;
        }

        return count;

    }

    public static class Activity {
        public final int start;
        public final int finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "start=" + start +
                    ", finish=" + finish +
                    '}';
        }
    }
}
