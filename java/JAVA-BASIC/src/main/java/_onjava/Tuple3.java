package _onjava;

public class Tuple3<A, B, C> extends Tuple2<A, B> {

    public final C a3;
    public Tuple3(A a, B b, C c) {
        super(a, b);
        this.a3 = c;
    }

    @Override
    public String rep() {
        return super.rep() + ", " + a3;
    }
}
