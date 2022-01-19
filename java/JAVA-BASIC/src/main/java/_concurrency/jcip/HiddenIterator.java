package _concurrency.jcip;

import javax.annotation.concurrent.GuardedBy;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class HiddenIterator {

    @GuardedBy("this")
    private final Set<Integer> set = new HashSet<>();

    public synchronized void add(Integer i) {
        set.add(i);
    }
    public synchronized void remove(Integer i) {
        set.remove(i);
    }

    public void addTenThings() {

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            add(random.nextInt());
        }
        System.out.println("DEBUG: added ten elements to " + set); // The Hidden Iteration

    }

}
