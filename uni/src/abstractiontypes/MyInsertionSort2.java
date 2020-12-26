package abstractiontypes;

public class MyInsertionSort2 {
    static int[] arr1 = {10, 34, 2, 56, 7, 67, 88, 42};

    public static void main(String a[]) {
        printArray(arr1);
        insertionSort(arr1, 1);
        printArray(arr1);
        insertionSort(arr1, 0);
        printArray(arr1);
    }

    // REQUIRES: arr to be non null, direction to be either 0 or 1
    // MODIFIES: arr
    // EFFECTS: orders the array arr, in decreasing/increasing order
    // decreasing if direction is 0
    // increasing if direction is 1
    public static void insertionSort(int[] arr, int direction) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1] && direction==1) {
                    swap(arr, j-1, j);
                } else if (arr[j] > arr[j-1] && direction==0){
                    swap(arr, j-1, j);
                }
            }
        }
    }

    // REQUIRES: arr to be non null; i,j valid indices for arr
    // (0 < i,j < arr.length)
    // MODIFIES: arr
    // EFFECTS: swaps element of index i with element of index j in arr
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
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


// Prendere il seguente esempio di codice Java e modificarlo in modo da realizzarne
// uno che abbia (almeno) un metodo in grado di ordinare o in maniera crescente o
// in maniera decrescente i dati.
// Tale metodo deve poter essere invocato indicando, in qualche modo, la direzione
// di ordinamento.
// 1. specificare il metodo (ed eventuali metodi accessori)
// 2. implementarlo