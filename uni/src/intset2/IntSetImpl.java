package intset2;

import java.util.Iterator;

public abstract class IntSetImpl implements IntSet {
    /**
     * this.currentSize stores the number of elements
     * in the set. It is cached to improve performance.
     *
     * INV:
     * 0 <= this.currentSize &
     * this.currentSize = the cardinality of the set
     */
    protected int currentSize = 0;// protected so that subtypes can change it

    public abstract void insert(int x);

    public abstract boolean remove(int x);

    public abstract boolean isIn(int x);

    public abstract int choose() throws EmptyIntSetException;

    public abstract Iterator<Integer> iterator();

    public abstract boolean sameValues(IntSet s2);

    public int size() {
        return (this.currentSize);
    }

    public int max() throws EmptyIntSetException {
        // this is a very inefficient implementation
        if (this.size() == 0) {
            throw new EmptyIntSetException();
        }
        Iterator<Integer> it = this.iterator();
        Integer max = it.next();
        while (it.hasNext()) {
            Integer x = it.next();
            if (x > max) {
                max = x;
            }
        }
        return (max);
    }
}
