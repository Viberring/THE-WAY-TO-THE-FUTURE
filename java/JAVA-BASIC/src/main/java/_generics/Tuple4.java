package _generics;

public class Tuple4<A, B, C, D> extends Tuple3<A, B, C> {
    public final D a4;

    public Tuple4(A a, B b, C c, D d) {
        super(a, b, c);
        a4 = d;
    }

    @Override
    public String toString() {
        return super.rep() + " , " + a4;
    }
}
