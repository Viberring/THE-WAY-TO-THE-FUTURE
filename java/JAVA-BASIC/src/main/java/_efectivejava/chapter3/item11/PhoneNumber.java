package _efectivejava.chapter3.item11;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author viber
 */
public class PhoneNumber {

    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix   = rangeCheck(prefix,   999, "prefix");
        this.lineNum  = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }

    @Override public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }


    /**
    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * Short.hashCode(prefix);
        result = 31 * Short.hashCode(lineNum);
        return result;
    }
    */
//    @Override
//    public int hashCode() {
//        return Objects.hash(areaCode, prefix, lineNum);
//    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(707, 867, 5309), "Jenny");
        m.put(new PhoneNumber(707, 867, 5309), "Jenny");
        System.out.println(m);
        System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
        System.out.println(m);
    }

}
