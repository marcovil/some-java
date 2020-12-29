package adt;

import java.util.Iterator;
import java.util.Objects;
import java.util.Vector;

/**
 * This class provides an ADT for polynomials with integer
 * not null coefficients and with non negative exponents: c_0+c_1*x+c_2*x^2+... .
 * Poly is immutable, unbounded.
 * The empty poly is 0=0*x^0.
 */
public class Poly {

    /**
     * a record that represents a single term of the poly:
     * c * x^e
     */
    private class PolynomialTerm implements Cloneable {
        int coeff;
        int exponent;

        PolynomialTerm(int c, int e) {
            this.coeff = c;
            this.exponent = e;
        }

        /**
         * Copy constructor
         *
         * @param ce: REQUIRE not null
         */
        PolynomialTerm(PolynomialTerm ce) {
            ce = Objects.requireNonNull(ce);
            this.coeff = ce.coeff;
            this.exponent = ce.exponent;
        }
    }

    /**
     * INVARIANT terms = the list of terms;
     * there is no relation between index of the term with exponent.
     * There can be terms with c=0.
     */
    private Vector<PolynomialTerm> terms;

    /**
     * @return: a new zero (empty) poly .
     */
    public Poly() {
        terms = new Vector<PolynomialTerm>();
    }

    /**
     * @param c: the coefficient
     * @param n: the exponent
     *           EFFECT constructs a new Poly c*x^n if c!=0; otherwise the zero Poly
     * @throws NegativeExponentException when n<0.
     */
    public Poly(int c, int n) throws NegativeExponentException {
        if (n < 0) {
            throw new NegativeExponentException();
        }
        terms = new Vector<PolynomialTerm>();
        if (c != 0) {
            PolynomialTerm ce = new PolynomialTerm(c, n);
            terms.addElement(ce);
        }
    }

    /**
     * Copy constructor
     * @param p REQUIRE non null
     */
    public Poly(Poly p) {
        this.terms = new Vector<PolynomialTerm>();
        for (PolynomialTerm pt : p.terms) {
            terms.addElement(pt);
        }
    }

    /**
     * @param p: the poly to be added to this; REQUIRE not null
     * @return a new poly that is this+p
     */
    public Poly add(Poly p) {
        Poly newp = new Poly();
        int highest_degree;
        if (this.degree() >= p.degree()) {
            highest_degree = this.degree();
        } else {
            highest_degree = p.degree();
        }
        for (int i=highest_degree; i>=0 ; i--) {
            int this_c = this.coefficient(i);
            int p_c = p.coefficient(i);
            int new_c = this_c + p_c;
            newp.terms.addElement(new PolynomialTerm(new_c, i));
        }
        return newp;
    }


    /**
     * @return the largest exponent in this with non zero coeff or 0 if this is the zero poly
     */
    public int degree() {
        assert (this.terms != null);
        if (this.terms.isEmpty()) {
            return (0);
        }
        int highest = 0;
        for (int i = 0; i < this.terms.size(); i++) {
            PolynomialTerm cpe = this.terms.get(i);
            if (cpe.exponent > highest) {
                highest = cpe.exponent;
            }
        }
        return (highest);
    }

    /**
     * @param n: an exponent.
     * @return the coefficient of the term in this
     * that has exponent n; possibly 0
     */
    public int coefficient(int n) {
        assert (this.terms != null);
        Iterator<PolynomialTerm> it = this.terms.iterator();
        while (it.hasNext()) {
            PolynomialTerm cpe = it.next();
            if (cpe.exponent == n) {
                return (cpe.coeff);
            }
        }
        return (0);
    }

    /**
     * @return the poly -(this)
     */
    public Poly minus() {
        Poly newp = new Poly();
        for (PolynomialTerm pt : this.terms) {
            newp.terms.addElement(new PolynomialTerm(-pt.coeff, pt.exponent));
        }
        return newp;
    }

    /**
     *  the poly to be multiplied to this; REQUIRE not null
     * @return a new poly that is this*p
     */
    public Poly mul(Poly p) {
        Poly new_poly = new Poly();
        for (PolynomialTerm pt_this : this.terms) {
            for (PolynomialTerm pt_p : p.terms) {
                Poly newp = null;
                try {
                    newp = new Poly(pt_this.coeff * pt_p.coeff, pt_this.exponent + pt_p.exponent);
                } catch (NegativeExponentException nee) {
                    System.out.println(nee);
                }
                new_poly = new_poly.add(newp);
            }
        }
        return new_poly;
    }

    public String toString() {
        assert (this.terms != null);
        StringBuffer s = new StringBuffer();
        Iterator<PolynomialTerm> it = this.terms.iterator();
        while (it.hasNext()) {
            PolynomialTerm cpe = it.next();
            s.append(String.format("%d*x^%d ", cpe.coeff, cpe.exponent));
        }
        return (s.toString());
    }
}
