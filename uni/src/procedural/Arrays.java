package procedural;

public class Arrays {
    public static void main(String a[]) {
        int[] arr1 = {10, 34, 2, 56, 7, 67, 88, 42};
        sort(arr1);
        for (int i : arr1) {
            System.out.print(i);
            System.out.print(", ");
        }
    }

    /**
     * MODIFY a, by sorting it increasingly
     *
     * @param a: the array to be sorted
     */
    public static void sort(int[] a) {
        if (a == null) {
            return;
        }
        quickSort(a, 0, a.length - 1);
    }

    /**
     * Sort a[low,...,high] in ascending order using the quicksort algorithm.
     * MODIFY a.
     *
     * @param a    the array to be sorted; REQUIRE a is not null
     * @param low  REQUIRE low >=0
     * @param high REQUIRE high < a.length
     */
    private static void quickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int middle = partition(a, low, high);
        quickSort(a, low, middle);
        quickSort(a, middle + 1, high);
    }

    /**
     * @param a: the array to reorder; REQUIRE a not null; MODIFY a
     * @param i: starting index in a; REQUIRE 0 <= i < j < a.length.
     * @param j: ending index in a;
     * @return res, an index in array a such that each element in a_post[i,..., res]
     * is smaller or equal to each element in a_post[res+1,...,j]. MODIFY a.
     */
    private static int partition(int[] a, int i, int j) {
        int current = a[i];
        while (true) {
            while (a[j] > current) {// do not touch greater elements
                j--;
            }
            while (a[i] < current) {// do not touch smaller elements
                i++;
            }
            if (i > j) {
                return j;
            } else {// there are elements that we haven't scanned yet: let's swap the extern
                swap(a, i, j);
                j--;
                i++;
            }
        }
    }

    /**
     * MODIFY a by exchanging elements a[i] and a[j].
     *
     * @param i: an index in a; REQUIRE 0 <= i < a.length
     * @param j: an index in a; REQUIRE 0 <= j < a.length
     * @param a: REQUIRE a not null.
     */
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}