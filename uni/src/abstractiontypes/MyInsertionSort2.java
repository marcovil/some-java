package abstractiontypes;

public class MyInsertionSort2 {
    static int[] arr1 = {10, 34, 2, 56, 7, 67, 88, 42};

    public static void main(String a[]) {
        printArray(arr1);
        insertionSort(arr1);
        printArray(arr1);
    }

    // REQUIRES: arr to be non null
    // MODIFIES: arr
    // EFFECTS: orders the array arr
    public static void insertionSort(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    // REQUIRES: arr to be non null
    // EFFECTS: prints the elements of arr to Standard Output
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }
}
