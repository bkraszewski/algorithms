package com.bartek;

import java.util.ArrayList;
import java.util.LinkedList;

public class PlusOne {
    public ArrayList<Integer> add(ArrayList<Integer> input) {
        LinkedList<Integer> ret = new LinkedList();

        int add = 1;
        for (int a = input.size() - 1; a >= 0; a--) {
            int current = input.get(a);
            current += add;
            add = 0;

            if (current > 9) {
                add = 1;
                current = 0;
            }

            ret.addFirst(current);
        }

        if (add > 0) {
            ret.addFirst(add);
        }

        int toRemove = 0;
        for (int a = 0; a < ret.size(); a++) {
            if (ret.get(a) == 0) {
                toRemove++;
                continue;
            } else {
                break;
            }
        }

        return new ArrayList<>(ret.subList(toRemove, ret.size()));
    }
}
