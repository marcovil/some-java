package exceptions;

public class Matrices {
    /** The mission of this class is to provide a number of
     * standalone procedures that can be useful for manipulating
     * n x m matrices of floats.
     **/

    public static void main (String args[]) {
        float[][] arr1 = { { 1,2,3,4}, {11,12,13,14}, {21,22,23,24} };
        float[][] arr2 = { { 1,1}, {2,2}, {3,3}, {0,0} };

        float[][] res = transpose(arr1);
        float[][] res2 = multiply(arr1,arr2);
    }

    /** compute the transpose matrix of m:
     result[i,j]=m[j,i]
     */
    public static float[][] transpose (float[][] m) {return null;}

    /** compute matrix multiplication of m1 with m2:
     result[i,j] = sum_over_h(m1[i,h]*m2[h,j])
     */
    public static float[][] multiply (float[][] m1, float[][] m2) {return null;}

}

//Rivedere la specifica definendo il contratto per i due metodi transpose e
//multiply. Eventualmente definire la specifica di altri metodi intermedi, che
//possono essere a scelta privati, pubblici o altro.
//Implementare tutti i metodi.
//(Suggerimento: definire o riusare le necessarie eccezioni e usare le asserzioni
//- quelle di base di Java, assert, non librerie esterne a Java quali cofoja o
//analoghe - e introdurre i necessari try/catch nel main).
//(Promemoria: float[][] rappresenta un array in cui ciascun elemento rappre
// senta una riga che consiste in un array di float.)