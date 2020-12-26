package javatypes;

public class StackHeap {

    public static void main (String[] arg) {
        String s1 = "ace";
        String s2 = "f";
        String s3 = s1;
        String s4 = s3 + s2;

        int[] a = {1, 2, 3};
        int[] b = new int[2];
        int[] c = a;
        int x = c[0];
    }

}
