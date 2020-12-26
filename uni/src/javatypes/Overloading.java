package javatypes;

public class Overloading {

    public static void main (String[] args){
        Object theObject = null;
        String theString = "aba";
        int theInt = 3;
        long theLong = 3L;

        C aC = new C();
        D aD = new D();
        D anotherD = new C();
        B aB = new B();

        aC.m(theString, theInt, theLong);
        //aC.m(theString, theInt, theInt);
        aC.m(theString, theLong, theInt);
        aC.m(theString, theLong, theLong);
        aC.m(theObject, theLong, theLong);
        aC.m(theObject, theInt, theInt);

        //aD.m(theString, theInt, theLong);
        //aD.m(theString, theInt, theInt);
        //aD.m(theString, theLong, theInt);
        //aD.m(theString, theLong, theLong);
        //aD.m(theObject, theLong, theLong);
        //aD.m(theObject, theInt, theInt);

        anotherD.m(theString, theInt, theLong);
        //anotherD.m(theString, theInt, theInt);
        anotherD.m(theString, theLong, theInt);
        anotherD.m(theString, theLong, theLong);
        anotherD.m(theObject, theLong, theLong);
        anotherD.m(theObject, theInt, theInt);

        aB.m(theString, theInt, theLong);
        //aB.m(theString, theInt, theInt);
        aB.m(theString, theLong, theInt);
        aB.m(theString, theLong, theLong);
        aB.m(theObject, theLong, theLong);
        aB.m(theObject, theInt, theInt);
    }

}

