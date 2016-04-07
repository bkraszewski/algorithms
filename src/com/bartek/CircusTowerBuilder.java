package com.bartek;

import java.util.Collections;
import java.util.List;

public class CircusTowerBuilder {
    public static List<Person> buildTower(List<Person> people) {

        Collections.sort(people, (Person o1, Person o2) -> {
            if (o1.weight < o2.weight && o1.height < o2.height) {
                return -1;
            } else {
                return 1;
            }
        });

        int prevWeight = 0;
        int prevHeight = 0;

        int index = 0;


        for (Person person : people) {
            if (person.weight > prevWeight && person.height > prevHeight) {
                index++;
                prevHeight = person.height;
                prevWeight = person.weight;
            } else {
                break;
            }
        }

        return people.subList(0, index);
    }

    public static class Person {

        private final int weight;
        private final int height;

        public Person(int height, int weight) {
            this.weight = weight;
            this.height = height;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (weight != person.weight) return false;
            return height == person.height;

        }

        @Override
        public int hashCode() {
            int result = weight;
            result = 31 * result + height;
            return result;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "height=" + height +
                    ", weight=" + weight +
                    '}';
        }
    }
}
