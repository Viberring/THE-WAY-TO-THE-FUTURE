package _onjava8._enums;

public class NonEnum {
    public static void main(String[] args) {

        Class<Integer> intClass = Integer.class;

        try {
            for (Object en : intClass.getEnumConstants()) {
                System.out.println(en   );
            }
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }

    }
}
