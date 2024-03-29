package refactor.java.ch08;

public class ReplaceRecordWithDataClass {
    class Person {
        public static final int O = 0;
        public static final int A = 1;
        public static final int B = 2;
        public static final int AB = 3;

        private int _bloodGroup;

        public Person(int bloodGroup) {
            _bloodGroup = bloodGroup;
        }

        public void setBloodGroup(int arg) {
            _bloodGroup = arg;
        }

        public int getBloodGroup() {
            return _bloodGroup;
        }
    }

    class BloodGroup {
        public static final BloodGroup O = new BloodGroup(0);
        public static final BloodGroup A = new BloodGroup(1);
        public static final BloodGroup B = new BloodGroup(2);
        public static final BloodGroup AB = new BloodGroup(3);
        private static final BloodGroup[] _values = { O, A, B, AB };
        private final int _code;

        private BloodGroup(int code) {
            _code = code;
        }

        public int getCode() {
            return _code;
        }

        public static BloodGroup code(int arg) {
            return _values[arg];
        }
    }
}
