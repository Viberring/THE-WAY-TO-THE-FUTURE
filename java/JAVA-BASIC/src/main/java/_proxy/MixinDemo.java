package _proxy;

import net.sf.cglib.proxy.Mixin;

public class MixinDemo {

    interface Interface1 {
        String first();
    }
    interface Interface2 {
        String second();
    }

    static class Class1 implements Interface1 {
        @Override
        public String first() {
            return "first";
        }
    }
    static class Class2 implements Interface2 {
        @Override
        public String second() {
            return "second";
        }
    }

    interface MixinInterface extends Interface1, Interface2 {

    }

    public static void main(String[] args) {
        Mixin mixin = Mixin.create(new Class[]{Interface1.class, Interface2.class, MixinInterface.class},
                new Object[]{new Class1(), new Class2()});
        MixinInterface mixinDelegate = (MixinInterface) mixin;
        System.out.println(mixinDelegate.first());
        System.out.println(mixinDelegate.second());
    }

}
