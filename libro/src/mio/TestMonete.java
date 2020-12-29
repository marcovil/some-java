package mio;

public class TestMonete {

    public static void main(String[] args) {

        Moneta moneta1 = new Moneta(20);
        Moneta moneta2 = new Moneta(1);
        Moneta moneta3 = new Moneta(100);

        PortaMonete portaMoneteDa8 = new PortaMonete(5,5,1,2,2,10,15,20);
        PortaMonete portaMoneteDa11 = new PortaMonete(1,1,1,1,1,5,5,5,5,5,20);

        portaMoneteDa8.stato();
        Moneta tolta = portaMoneteDa8.preleva(5);
        System.out.println(tolta.getDescrizione());
        portaMoneteDa8.stato();

        PortaMonete vuoto = new PortaMonete();
        vuoto.preleva(2);

    }

}
