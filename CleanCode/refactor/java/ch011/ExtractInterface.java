package refactor.java.ch011;

public class ExtractInterface {
    double charge(Employee emp, int days) {
        int base = emp.getRate() * days;
        if (emp.hasSpecialSkill())
            return base * 1.05;
        else
            return base;
    }

    interface Billable {
        public int getRate();

        public boolean hasSpecialSkill();
    }

    class Employee implements Billable {

    }

    double charge(Billable emp, int days) {
        int base = emp.getRate() * days;
        if (emp.hasSpecialSkill())
            return base * 1.05;
        else
            return base;
    }

}
