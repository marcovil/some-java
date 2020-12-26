package javatypes;

public class C extends D {
    void m(Object o, long x, long y) {
        System.out.println("C1");
    }
    void m(String s, int x, long y) {
        System.out.println("C2");
    }
    void m(Object o, int x, long y) {
        System.out.println("C3");
    }
    void m(String s, long x, int y) {
        System.out.println("C4");
    }
}