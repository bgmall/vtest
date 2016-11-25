package vtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by 37 on 2016/9/23.
 */
public class Main {

    static class Person {
        long id;
        int x;
        int y;

        public Person(long id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
//        long v1 = Long.MAX_VALUE;
//        long v2 = Long.MAX_VALUE;
//        double v = (double) v1 / v2;
//        System.out.println(v);

        long number = 100;
        long start = System.nanoTime();
        Map<Long, Person> players = new HashMap<>();
        for (long i = 0; i < number; i++) {
            Person person = new Person(i);
            players.put(i, person);
        }
        System.out.println(players.size() +  " " + (System.nanoTime() - start) / 1000);
        start = System.nanoTime();
        List<Person> persons = new ArrayList<>();
        for (long i = 0; i < number; i++) {
            Person person = new Person(i);
            persons.add(person);
        }
        System.out.println(persons.size() +  " " + (System.nanoTime() - start) / 1000);

        long i = 50;
//        Person person = persons.get(100);
//        start = System.nanoTime();
//        players.remove(i);
//        System.out.println((System.nanoTime() - start) / 1000);
//        persons.remove(person);
//        System.out.println((System.nanoTime() - start) / 1000);


        start = System.nanoTime();
        players.get(i);
        System.out.println((System.nanoTime() - start) / 1000);
        start = System.nanoTime();
        for (Person p : persons) {
            if (p.id == 50) {
                break;
            }
        }
        //find2(persons, 100);
        System.out.println((System.nanoTime() - start) / 1000);
    }

    private static Person find(List<Person> persons, int id) {
        Optional<Person> first = persons.stream().filter(person -> person.id == id).findFirst();
        return first.get();
    }

    private static Person find2(List<Person> persons, int id) {
        for (Person p : persons) {
            if (p.id == id) {
                return p;
            }
        }
        return null;
    }
}
