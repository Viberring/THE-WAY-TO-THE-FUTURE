package _arrays;

import java.util.stream.LongStream;

import static _onjava.ArrayShow.*;

public class CountUpward {

    static long[] fillCounted(int size) {
        return LongStream.iterate(0, i -> i + 1)
                .limit(size).toArray();
    }

    public static void main(String[] args) {
        long[] l1 = fillCounted(20);
        show(l1);
    }

}
