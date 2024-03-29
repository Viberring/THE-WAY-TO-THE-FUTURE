package _generics;

public class Tuple2<A, B> {
    public final A a1;
    public final B a2;

    public Tuple2(A a, B b) {
        a1 = a;
        a2 = b;
    }

    public String rep() {
        return a1 + " , " + a2;
    }

    public String toString() {
        return "( " + rep() + " )";
    }
}
