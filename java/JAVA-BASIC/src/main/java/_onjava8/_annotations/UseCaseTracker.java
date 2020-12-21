package _onjava8._annotations;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UseCaseTracker {
    public static void
    trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {

            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println(
                        ">> " + uc.id() + " \n " + uc.description()
                );
                useCases.remove(Integer.valueOf(uc.id()));
            }
            useCases.forEach(
                    i -> System.out.println("Missing use case " + i)
            );

        }
    }

    public static void main(String[] args) {
        List<Integer> usecases = IntStream.range(34, 38)
                .boxed().collect(Collectors.toList());
        trackUseCases(usecases, PasswordUtils.class);
    }
}
