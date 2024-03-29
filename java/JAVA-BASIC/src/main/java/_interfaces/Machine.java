package _interfaces;


class Bing implements Operations {
    @Override
    public void execute() {
        Operations.show("Bing");
    }
}

class Crack implements Operations {
    @Override
    public void execute() {
        Operations.show("Crack");
    }
}

public class Machine {
    public static void main(String[] args) {
        Operations.runOps(new Bing(), new Crack());
    }
}
