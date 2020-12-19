package intset2;

import java.util.Iterator;

import intset2.IntSetFactory.IntSetKind;

public class IntSetMain {
    public static void main(String[] args) {
        IntSetFactory fact = new IntSetFactory();
        esempio_con_IntSet(fact);
        try {
            esempio_con_MaxIntSet(fact);
        } catch (EmptyIntSetException e) {
            e.printStackTrace();
        }
    }

    private static void esempio_con_MaxIntSet(IntSetFactory fact) throws EmptyIntSetException {
        System.out.format("\n\n\n Esempi con MaxIntSet\n");
        int[] a = {1, 2, 3};
        // here the client does not know what kind of classes we're using
        IntSet s2 = fact.createIntSet(IntSetKind.withMax, a);
        System.out.format("\nClasse di s2=%s", s2.getClass().

                getSimpleName());
        s2.insert(13);
        s2.insert(8);
        Iterator<Integer> it2 = s2.iterator();
        for (
                int i = 0; it2.hasNext(); i++) {
            System.out.format("\ns2[%d]=%d", i, it2.next());
        }
        System.out.format("\nmax di s2=%d", s2.max());
        s2.remove(13);
        it2 = s2.iterator();
        for (
                int i = 0; it2.hasNext(); i++) {
            System.out.format("\ns2[%d]=%d", i, it2.next());
        }
        System.out.format("\nmax di s2=%d", s2.max());
        s2.remove(1);
        System.out.format("\nmax di s2=%d", s2.max());
    }

    private static void esempio_con_IntSet(IntSetFactory fact) {
// here the client does not know what kind of classes we're using
        IntSet s1 = fact.createIntSet(IntSetKind.unordered);
        s1.insert(1);
        s1.insert(3);
        s1.insert(2);
        s1.insert(2);
        boolean found = s1.isIn(2);
        found = s1.isIn(10);
        int[] a = {1, 2, 3};
        IntSet s2 = fact.createIntSet(IntSetKind.unordered, a);

        IntSet s3 = fact.createIntSet(IntSetKind.unordered);
        try {
            int z;
            z = s1.choose();
            System.out.format("\ns1.choose = %s", z);
            z = s1.choose();
            System.out.format("\ns1.choose = %s", z);
            z = s1.choose();
            System.out.format("\ns1.choose = %s", z);
            z = s1.choose();
            System.out.format("\ns1.choose = %s", z);
            z = s3.choose();
        } catch (
                EmptyIntSetException e) {
            e.printStackTrace();
        }

        boolean same = s1.equals(s2);
        System.out.format("\nEquals = %s", same);
// NB for mutable objects, equals returns false even if they have same state
        same = s1.sameValues(s2);
        System.out.format("\nSameValues = %s", same);
        System.out.format("\ns1 hascode=%s", s1.hashCode());
        System.out.format("\ns2 hascode=%s", s2.hashCode());
        s1.insert(13);
        System.out.format("\ns1 hascode=%s", s1.hashCode());
        IntSet s4 = fact.createIntSet(IntSetKind.unordered, s1);
        System.out.format("\ns4 hascode=%s", s4.hashCode());
        s4.insert(33);
        // ==================== generic iterator =======================
// print all items
        Iterator<Integer> it2 = s4.iterator();
        for (
                int i = 0; it2.hasNext(); i++) {
            System.out.format("\ns4[%d]=%d", i, it2.next());
        }
// compute the sum
        it2 = s4.iterator();// need to create a new iterator
        int tot = 0;
        while (it2.hasNext()) {
            tot = tot + it2.next();
        }
        System.out.format("\ntot=%d", tot);
        // compute the sum of x^2 s.t. x<k
        int tot2 = 0;
        int k = 10;
        it2 = s4.iterator();
        while (it2.hasNext()) {
            Integer x = it2.next();
            if (x < k) {
                tot2 = tot2 + x * x;
            }
        }
        System.out.format("\ntot2=%d", tot2);
    }
}