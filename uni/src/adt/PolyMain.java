package adt;

public class PolyMain {

    public static void main(String[] args) {

        Poly p1 = null;
        Poly p2 = null;
        Poly p3 = null;
        Poly p4 = null;
        Poly p5 = null;

        try {
            p1 = new Poly(3, 2);
            p2 = new Poly(3, 3);
            p3 = new Poly(4,5);
            p4 = new Poly(6,2);
            p5 = new Poly(8, 3);
        } catch (NegativeExponentException nee) {
            System.out.println(nee);
        }

        Poly p6 = p1.add(p3);
        Poly p7 = p2.add(p4);
        Poly p8 = p7.add(p5);

        System.out.println(p6);
        System.out.println(p7);
        System.out.println(p8);

        System.out.println(p6.mul(p7));
        System.out.println(p7.mul(p8));
        System.out.println(p7.mul(p8).minus());

    }

}
