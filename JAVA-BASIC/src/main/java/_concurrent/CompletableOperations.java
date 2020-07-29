package _concurrent;

import java.util.concurrent.CompletableFuture;
import static _concurrent.CompletableUtilities.*;

public class CompletableOperations {
    static CompletableFuture<Integer> cfi(int i) {
        return CompletableFuture.completedFuture(
                Integer.valueOf(i)
        );
    }

    public static void main(String[] args) {
        shower(cfi(1));
    }
}
