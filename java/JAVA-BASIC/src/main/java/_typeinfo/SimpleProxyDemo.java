package _typeinfo;

interface Interface {
    void doSomething();
    void somethingElse(String arg);
}
class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println(" doSomething ");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println(" something Else " + arg);
    }
}
class SimpleProxy implements Interface {
    private Interface proxied;
    SimpleProxy(Interface proxied) { this.proxied = proxied; }

    @Override
    public void doSomething() {
        System.out.println( " SimpleProxy doSomething ");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println(" SimpleProxy doSomething Else " + arg);
        proxied.somethingElse(arg);
    }
}
public class SimpleProxyDemo {
}
