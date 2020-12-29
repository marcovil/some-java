package exceptions;

public class StudentScore {

    public static void main(String[] args) {
        int [] arr1 = {18,20,19,27,28,21};
        try {
            MyArrays.addWithThreshold(arr1, 5, 30);
        } catch (ThresholdExceededException tee) {
            System.err.println(tee);
        } finally {
            System.err.println("Finally Reached");
        }
    }

}
