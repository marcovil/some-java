package intset2;

/**
 * MISSION
 * to provide methods for creating instances of IntSet
 */
public class IntSetFactory {
    public enum IntSetKind {
        ordered, unordered, withMax
    }

    /**
     * @param kind: the type of IntSet to create
     * @return an empty instance of the set
     */
    public IntSet createIntSet(IntSetKind kind) {
        IntSet res;
        switch (kind) {
            case unordered:
                res = new UnorderedIntSet();
                break;
            case withMax:
                res = new MaxIntSet();
                break;
            case ordered:
                res = new MaxIntSet();
                break;
            default:
                res = new UnorderedIntSet();
                break;
        }
        return (res);
    }

    /**
     * @param kind: the type of IntSet to create
     * @param data  the ints to be added
     * @return an empty instance of the set
     */
    public IntSet createIntSet(IntSetKind kind, int[] data) {
        IntSet res;
        switch (kind) {
            case unordered:
                res = new UnorderedIntSet(data);
                break;
            case withMax:
                res = new MaxIntSet(data);
                break;
            case ordered:
                res = new MaxIntSet(data);
                break;
            default:
                res = new UnorderedIntSet(data);
                break;
        }
        return (res);
    }

    /**
     * @param kind: the type of IntSet to create
     * @param s     the ints to be added
     * @return an empty instance of the set
     */
    public IntSet createIntSet(IntSetKind kind, IntSet s) {
        IntSet res;
        switch (kind) {
            case unordered:
                res = new UnorderedIntSet(s);
                break;
            case withMax:
                res = new MaxIntSet(s);
                break;
            case ordered:
                res = new MaxIntSet(s);
                break;
            default:
                res = new UnorderedIntSet(s);
                break;
        }
        return (res);
    }
}
