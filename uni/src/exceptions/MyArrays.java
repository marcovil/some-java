package exceptions;

public class MyArrays {

    /**
     * Add x to each element of a unless result is bigger than b
     * @param a the array to be added to, REQUIRE non null, MODIFY a
     * @param x the quantity to be added to each element of the array
     * @param b the threshold not to be surpassed
     * @throws ThresholdExceededException if a adding x to an element i makes the result bigger than b
     **/
    public static void addWithThreshold (int [] a, int x, int b) throws ThresholdExceededException
    {
        for (int i=0; i<a.length; i++) {
            if (a[i]+x < b) {
                a[i] = a[i] + x;
            } else {
                throw new ThresholdExceededException("Threshold exceeded at index " + i);
            }
        }
    }





}
