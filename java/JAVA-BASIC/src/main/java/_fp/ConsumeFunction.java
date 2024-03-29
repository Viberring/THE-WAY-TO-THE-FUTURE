package _fp;



import java.util.function.Function;

class One {}
class Two {}

public class ConsumeFunction {
    static Two consume(Function<One, Two> ontTwo) {
        return ontTwo.apply(new One());
    }

    public static void main(String[] args) {
        Two two = consume(one -> new Two());
    }
}
