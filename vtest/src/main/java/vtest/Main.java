package vtest;

import com.koloboke.collect.map.IntIntMap;
import com.koloboke.collect.map.hash.HashIntIntMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import rawMap.IntIntMap4a;

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

    static class KV {
        int i;
        int j;

        public KV(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public void setI(int i) {
            this.i = i;
        }

        public void setJ(int j) {
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            KV kv = (KV) o;

            return i == kv.i;

        }

        @Override
        public int hashCode() {
            return i;
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

        int count = 64;
        Map<Integer, Integer> attributes1 = new HashMap<>(count);
        Map<Integer, Integer> attributes2 = new HashMap<>(count);
        List<KV> attribs1 = new ArrayList<>(count);
        List<KV> attribs2 = new ArrayList<>(count);
        Map<Integer, Integer> attribute1_kb = HashIntIntMaps.newMutableMap(count);
        Map<Integer, Integer> attribute2_kb = HashIntIntMaps.newMutableMap(count);
        for (int j = 0; j < count; j++) {
            attributes1.put(j, j);
            attributes2.put(j, j);
            attribs1.add(new KV(j, j));
            attribs2.add(new KV(j, j));
            attribute1_kb.put(j, j);
            attribute2_kb.put(j, j);
        }

        start = System.nanoTime();
        Map<Integer, Integer> attributes = new HashMap<>(count);
        attributes.putAll(attributes2);
        for (Map.Entry<Integer, Integer> entry : attributes1.entrySet()) {
            Integer key = entry.getKey();
            Integer v2 = attributes.get(key);
            if (v2 != null) {
                attributes.put(key, entry.getValue() + v2);
            } else {
                attributes.put(key, entry.getValue());
            }
        }
        System.out.println((System.nanoTime() - start) / 1000 + " size=" + attributes.size());


        start = System.nanoTime();
        Map<Integer, Integer> attributes_stream = new HashMap<>(attributes1);
        attributes2.forEach((k, v) -> attributes_stream.merge(k, v, (integer, integer2) -> integer + integer2));
        System.out.println((System.nanoTime() - start) / 1000);

        start = System.nanoTime();
        Map<Integer, Integer> attributes_kb = HashIntIntMaps.newMutableMap(count);
        attributes_kb.putAll(attribute2_kb);
        for (Map.Entry<Integer, Integer> entry : attribute1_kb.entrySet()) {
            Integer key = entry.getKey();
            Integer v2 = attributes_kb.get(key);
            if (v2 != null) {
                attributes_kb.put(key, entry.getValue() + v2);
            } else {
                attributes_kb.put(key, entry.getValue());
            }
        }
        System.out.println((System.nanoTime() - start) / 1000 + " size=" + attributes_kb.size());


//        start = System.nanoTime();
//        List<KV> attribs = new ArrayList<>(50);
//        attribs.addAll(attribs2);
//        for (KV kv : attribs1) {
//            int index = attribs.indexOf(kv);
//            if(-1 == index) {
//                attribs.add(kv);
//            } else {
//                KV kv2 = attribs.get(index);
//                kv2.setJ(kv2.getJ() + kv.getJ());
//            }
//        }
//        System.out.println((System.nanoTime() - start) / 1000 + " size=" + attribs.size());
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
