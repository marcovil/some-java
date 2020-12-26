package javatypes;

import java.util.Collections;
import java.util.Vector;

public class InsertionSortVector {
    static Vector<Integer> vector = new Vector<Integer>();
    static int[] arr1 = {10, 34, 2, 56, 7, 67, 88, 42};

    public static void main(String[] a) {

        for (int i : arr1) {
            vector.addElement(i);
        }

        System.out.println(vector);
        insertionSort(vector);
        System.out.println(vector);
    }

    // REQUIRES: vec to be non null
    // MODIFIES: vec
    // EFFECTS: orders the vector vec
    public static void insertionSort(Vector<Integer> vec) {
        Integer temp;
        for (int i = 1; i < vec.size(); i++) {
            for (int j = i; j > 0; j--) {
                if (vec.get(j) < vec.get(j - 1)) {
                    temp = vec.get(j);
                    vec.removeElementAt(j);
                    vec.insertElementAt(vec.get(j-1), j);
                    vec.removeElementAt(j-1);
                    vec.insertElementAt(temp,j-1);
                }
            }
        }
    }
}
