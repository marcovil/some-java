package intset2;

import java.util.Iterator;

/**
 * MISSION of this class is to provide a specialized version
 * of UnorderedIntSet with the ability to quickly compute the maximum value
 * of the set.
 */
public class MaxIntSet extends UnorderedIntSet {
    private Integer highestValue = null;

    /**
     * ABSTRACTION FUNCTION: the same as UnorderedIntSet
     *
     * @return true if the invariant of this class holds
     * @see UnorderedIntSet
     * <p>
     * INVARIANT: when this set is not empty then this.highestValue contains the
     * maximum value of the set. If the set is empty then highestValue=null.
     */
    protected boolean inv_MaxIntSet() {
        boolean res = (highestValue != null) ? (this.size() > 0) : this.size() == 0;
        res = res && super.inv_UnorderedIntSet();
        return (res);
    }

    /**
     * Default constructor
     */
    public MaxIntSet() {
        super();
    }

    /**
     * EFFECT: initialize the instance this with the values stored in
     * data. Avoid creating duplicates.
     *
     * @param data: a list of ints, REQUIRE not null
     */
    public MaxIntSet(int[] data) {
        super(data);
        for (int i = 0; i < data.length; i++) {
            if (highestValue == null || highestValue < data[i]) {
                highestValue = new Integer(data[i]);
            }
        }
        assert inv_MaxIntSet();
    }

    /**
     * EFFECT: initialize a new instance of MaxIntSet
     * with the values stored in s.
     *
     * @param s: an UnorderedIntSet, REQUIRE not null
     */
    public MaxIntSet(IntSet s) {
        super(s);
        Iterator<Integer> it = s.iterator();
        while (it.hasNext()) {
            Integer x = it.next();
            if (highestValue == null || highestValue < x) {
                highestValue = x;
            }
        }
        assert inv_MaxIntSet();
    }

    public void insert(int x) {
        assert inv_MaxIntSet();
        super.insert(x);
        if (highestValue == null || highestValue < x) {
            highestValue = new Integer(x);
        }
        assert inv_MaxIntSet();
        assert (highestValue >= x);
    }

    public boolean remove(int x) {
        assert inv_MaxIntSet();
        boolean res = super.remove(x);
        if (highestValue == null || x < highestValue) {
// nothing to do
        } else { // reset the highest value by scanning all values
            Iterator<Integer> it = this.iterator();
            highestValue = it.next();
            while (it.hasNext()) {
                Integer z = it.next();
                if (highestValue < z) {
                    highestValue = z;
                }
            }
        }
        assert inv_MaxIntSet();
        return (res);
    }

    /**
     * @return the maximum value of the set
     * @throws EmptyIntSetException if the set is empty
     */
    public int max() throws EmptyIntSetException {
        assert inv_MaxIntSet();
        if (highestValue == null) {
            throw new EmptyIntSetException();
        }
        return highestValue.intValue();
    }
}
