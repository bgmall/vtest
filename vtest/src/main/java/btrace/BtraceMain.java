package btrace;

/**
 * Created by msg on 2016/11/29.
 */
public class BtraceMain {

    static class A {
        private int value;

        A(int v) {
            this.value = v;
        }
    }

    public static void main(String[] args) {
        A[] as= new A[8];
        for (int i = 0; i < 8; i++) {
            as[i] = new A(i);
        }

        while(true) {

        }
    }
}
