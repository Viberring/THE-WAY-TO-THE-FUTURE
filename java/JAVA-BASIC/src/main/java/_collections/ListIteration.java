package _collections;

import onjava8._typeinfo.pets.Pet;
import onjava8._typeinfo.pets.Pets;

import java.util.List;
import java.util.ListIterator;

public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.list(8);
        ListIterator<Pet> it = pets.listIterator();
        while (it.hasNext())
            System.out.println(
                    it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; "
            );
        System.out.println();
        while (it.hasPrevious())
            System.out.println(it.previous());
        System.out.println();
        System.out.println(pets);

        it = pets.listIterator(3);
        while (it.hasNext()) {
            it.next();
            it.set(Pets.get());
        }
        System.out.println(pets);
    }
}
