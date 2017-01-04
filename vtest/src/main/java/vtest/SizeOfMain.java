package vtest;

import com.bgmall.SizeOfAgent;

/**
 * Created by msg on 2016/12/6.
 */
public class SizeOfMain {

    static class Person {
        int x;
        int y;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Person person = new Person(0, 0);
        System.out.println("Person fullSize=" + SizeOfAgent.fullSizeOf(person));
    }
}
