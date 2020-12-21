package _onjava8._typeinfo;

import java.util.function.Supplier;

public class Operation {
    public final Supplier<String> description;
    public final Runnable command;
    public Operation(Supplier<String> descr, Runnable cmd) {
        description = descr;
        command = cmd;
    }
}
