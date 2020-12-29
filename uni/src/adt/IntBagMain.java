package adt;

public class IntBagMain {

    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5, 5, 4, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};

        IntBag i1 = new IntBag(arr1);
        IntBag i2 = new IntBag(arr2);
        IntBag i3 = new IntBag();

        System.out.println(i1.size());

        System.out.println(i1.remove(5));
        System.out.println(i1.size());
        System.out.println(i1.isIn(5));

        System.out.println(i1.remove(1));
        System.out.println(i1.size());
        System.out.println(i1.isIn(1));

        System.out.println(i1.remove(4));
        System.out.println(i1.size());
        System.out.println(i1.isIn(4));

        System.out.println(i1.sameValues(i2));

        i1.insert(4);
        System.out.println(i1.size());

        i1.insert(5);
        System.out.println(i1.size());

        i1.insert(1);
        System.out.println(i1.size());

        System.out.println(i1.sameValues(i2));

        try {
            int randomElement = i1.choose();
            System.out.println(randomElement);
        } catch (EmptyIntBagException eie) {
            System.out.println(eie);
        }

        for (int i=1; i<=5; i++) {
            i3.insert(i);
        }

        System.out.println(i3.sameValues(i1));
        i3.insert(6);
        System.out.println(i3.sameValues(i1));

    }

}
