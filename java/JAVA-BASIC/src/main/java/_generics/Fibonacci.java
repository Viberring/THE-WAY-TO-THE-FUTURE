package _generics;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Fibonacci implements Supplier<Integer> {

    private int count = 0;

    @Override
    public Integer get() {
        return fib(count++);
    }
    private int fib(int n) {
        if (n < 2) return 1;
        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        Stream.generate(new Fibonacci()).limit(19).map(n -> n + " ").forEach(System.out::println);
    }

}
