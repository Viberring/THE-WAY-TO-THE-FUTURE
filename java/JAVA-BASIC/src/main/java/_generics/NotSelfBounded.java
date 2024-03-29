package _generics;

public class NotSelfBounded<T> {
    T element;
    NotSelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }
    T get( ) { return element; }

    public static void main(String[] args) {
        E2 e = new E2();
        e.set(new D2());
        System.out.println(e.get().getClass().getSimpleName());
    }
}

class A2 extends NotSelfBounded<A2> {}
class B2 extends NotSelfBounded<A2> {}

class C2 extends NotSelfBounded<C2> {
    C2 setAndGet(C2 arg) { set(arg); return get(); }
}

class D2 {}
class E2 extends NotSelfBounded<D2> {}
