package intset2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.Vector;

/**
 * MISSION
 * This class provides an ADT for unordered sets of int.
 */
public class UnorderedIntSet extends IntSetImpl {
    private Vector<Integer> elements;

    /**
     * ABSTRACTION FUNCTION: the set is represented by the items in this.elements
     * which are not sorted.
     *
     * INVARIANT elements != null & this.elements contains no duplicates &
     * this.elements contains boxed int (Integer) &
     * INV_IntSetImpl.
     */
    protected boolean inv_UnorderedIntSet() {
        boolean res = (this.elements != null);
        Set<Integer> set = new HashSet<Integer>(this.elements);
        res = res && (set.size() == this.elements.size());
        return (res);
    }

    /**
     * constructor
     * EFFECT; initialize this to a new set, empty.
     */
    public UnorderedIntSet() {
        this.elements = new Vector<Integer>();
        this.currentSize = 0;
    }

    /**
     * @param: elts. REQUIRE be not null.
     * EFFECT initialize this to a new set, which contains each element
     * of elts; duplicated elements are not considered.
     */
    public UnorderedIntSet(int[] elts) {
        this.elements = new Vector<Integer>();
        Objects.requireNonNull(elts);
        for (int x : elts) {
            Integer y = new Integer(x);
            if (!this.elements.contains(y)) {
                this.elements.addElement(y);
            }
        }
        this.currentSize = elts.length;
        assert inv_UnorderedIntSet();
    }

    public int size() {
        assert inv_UnorderedIntSet();
        return (this.elements.size());
    }

    /**
     * Copy constructor.
     * EFFECT initialize this to a new set that contains all and only
     * the elements of s.
     *
     * @param s: a set to be duplicated. REQUIRE not null.
     */
    public UnorderedIntSet(IntSet s) {
        Objects.requireNonNull(s);
        this.elements = new Vector<Integer>();
        Iterator<Integer> it = s.iterator();
        while (it.hasNext()) {
            this.elements.addElement(it.next());
        }
        this.currentSize = s.size();
        assert inv_UnorderedIntSet();
    }

    public void insert(int x) {
        assert inv_UnorderedIntSet();
        Integer y = new Integer(x);
        if (!this.elements.contains(y)) {
            this.elements.addElement(y);
            this.currentSize++;
        }
        assert (this.elements.contains(y));
        assert inv_UnorderedIntSet();
    }

    public boolean remove(int x) {
        assert inv_UnorderedIntSet();
        Integer y = new Integer(x);
        boolean res = this.elements.remove(y);
        if (res) {
            this.currentSize--;
        }
        assert (!this.elements.contains(y));
        assert inv_UnorderedIntSet();
        return (res);
    }

    public boolean isIn(int x) {
        assert inv_UnorderedIntSet();
        Integer y = new Integer(x);
        int i = this.indexOf(y);
        boolean res = (i >= 0);
        assert (!res || this.elements.contains(y)) : "res implies (y in elements)";
        return (res);
    }

    /**
     * @return: the index of x if it is present in this ;
     * return -1 if not present
     */
    private int indexOf(Integer x) {
        assert (this.elements != null);
        for (int i = 0; i < this.elements.size(); i++) {
            if (this.elements.get(i).equals(x)) {
                return (i);
            }
        }
        return (-1);
    }

    public int choose() throws EmptyIntSetException {
        assert inv_UnorderedIntSet();
        if (this.elements.isEmpty()) {
            throw new EmptyIntSetException();
        }
        Random randomGenerator = new Random();
        int x = randomGenerator.nextInt(this.elements.size());
        return (this.elements.elementAt(x));
    }

    /**
     * @param s2: REQUIRE not null
     * @return true if this and s2 contain the same set of int
     */
    public boolean sameValues(IntSet s2) {
        Objects.requireNonNull(s2);
        assert inv_UnorderedIntSet();
        if (this.currentSize != s2.size()) {
            return (false);
        }
        for (Integer x : this.elements) {
            if (!s2.isIn(x)) {
                return (false);
            }
        }
        return (true);
    }

    /**
     * @return a standard iterator over the Integers of this set. The iterator
     * is not sensible to mutations of this set.
     * This is a second version of the iterator.
     */
    public Iterator<Integer> iterator() {
        assert (this.elements != null);
        IntSetIterator result = new IntSetIterator(this);
        return ((Iterator<Integer>) result);
    }
    /** =============================================
     *
     INNER CLASS for generic iterator
     * =============================================
     */
    /**
     * MISSION is to provide an iterator over the elements
     * of an UnorderedIntSet.
     * Once the iterator is created, if the original set changes
     * the iterator continues to work on the original copy.
     */
    private class IntSetIterator implements Iterator<Integer> {
        /**
         * INVARIANT
         * elements contains a copy of the elements of the UnorderedIntSet when
         * this iterator is created.
         * current is the integer i such that elements[i] is the first of the elements
         * not yet returned. current==elements.size if we explored all of them.
         */
        private int current;
        final private Vector<Integer> elements;

        /**
         * @param s an UnorderedIntSet REQUIRE not null
         *          Initialize the iterator with the size of the vector and
         *          with current index=0, and store a copy of the elements.
         */
        @SuppressWarnings("unchecked")
        IntSetIterator(UnorderedIntSet s) {
            Objects.requireNonNull(s);
            this.elements = (Vector<Integer>) s.elements.clone();
            this.current = 0;
        }

        @Override
        public boolean hasNext() {
            return (this.current < this.elements.size());
        }

        @Override
        public Integer next() {
            if (this.current < this.elements.size()) {
                Integer res = this.elements.get((int) this.current);
                this.current++;
                return (res);
            } else {
                throw new NoSuchElementException("Went beyond the available values");
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}