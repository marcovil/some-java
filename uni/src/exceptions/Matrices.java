package exceptions;

public class Matrices {
    /** The mission of this class is to provide a number of
     * standalone procedures that can be useful for manipulating
     * n x m matrices of floats.
     **/

    public static void main (String args[]) {
        float[][] arr1 = { { 1,2,3,4}, {11,12,13,14}, {21,22,23,24} };
        float[][] arr2 = { {1,1}, {2,2}, {3,3}, {0,0} };
        float[] vec1 = {5, 6, 7, 8};
        float[] vec2 = {2, 2, 2, 2};
        float[] vec3 = {2, 3, 4};
        float[] vec4 = null;

        float[][] res_0 = transpose(arr1);
        print2Dmatrix(res_0);

        try {
            float res_1 = dotProduct(vec1, vec2);
            System.out.println(res_1);
        } catch (NonMultipliableVectorsException e) {
            e.printStackTrace();
        }

        try {
            float res_2 = dotProduct(vec2, vec3);
        } catch (NonMultipliableVectorsException e) {
            e.printStackTrace();
        }

        try {
            float[][] res_3 = multiply(arr1, arr2);
            print2Dmatrix(res_3);
        } catch (NonMultipliableMatricesException e) {
            e.printStackTrace();
        }
    }

    /**
     * REQUIRES: all elements of m are floats
     * EFFECTS: if m is null throws NullPointerException, otherwise
     * computes the transpose matrix of m: result[i,j]=m[j,i]
     */
    public static float[][] transpose (float[][] m) throws NullPointerException
    {
        float[][] newM = new float[m[0].length][m.length];

        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m[i].length; j++) {
                newM[j][i] = m[i][j];
            }
        }
        return newM;
    }

    /**
     * REQUIRES: m1 dimensions compatible with m2 (m1 columns = m2 rows)
     * EFFECTS: if m1 or m2 are null throws NullPointerException, otherwise
     * computes matrix multiplication of m1 with m2: result[i,j] = sum_over_h(m1[i,h]*m2[h,j])
     */
    public static float[][] multiply (float[][] m1, float[][] m2) throws NullPointerException, NonMultipliableMatricesException
    {
        if (m1[0].length != m2.length) { throw new NonMultipliableMatricesException(); };

        float[][] new_m = new float[m1.length][m2[0].length];
        float[][] transposed_m2 = transpose(m2);

        for (int i=0; i<new_m.length; i++) {
            for (int j=0; j<new_m[i].length; j++) {
                try {
                    new_m[i][j] = dotProduct(m1[i],transposed_m2[j]);
                } catch (NonMultipliableVectorsException e) {
                    e.printStackTrace();
                }
            }
        }

        return new_m;
    }

    /**
     * REQUIRES: vectors v1 and v2 of the same length
     * EFFECTS: if v1 and v2 are of different length, throws NonMultipliableVectorsException
     * if v1 or v2 null throws NullPointerException, otherwise
     * returns a scalar, which is the dot product of the two vectors
     */
    public static float dotProduct (float[] v1, float[] v2) throws NullPointerException, NonMultipliableVectorsException
    {
        if (v1.length != v2.length) { throw new NonMultipliableVectorsException(); }
        float res = 0;
        for (int i=0; i<v1.length; i++) {
            res = res + v1[i]*v2[i];
        }
        return res;
    }

    /**
     * REQUIRES: all elements of mat are floats
     * EFFECTS: if mat is null throws NullPointerException, otherwise
     * prints the elements of mat to standard output
     */
    public static void print2Dmatrix (float[][] mat) throws NullPointerException
    {
        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[i].length; j++) {
                System.out.print(mat[i][j]);
                if (j<mat[i].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

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