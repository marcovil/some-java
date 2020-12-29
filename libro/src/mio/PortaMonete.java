package mio;

/**
 * Astrae il concetto di PortaMonete, contiene un massimo di dieci monete
 */
public class PortaMonete {

    /**
     * Rappresentazione interna
     */
    private final Moneta[] monete = new Moneta[10];
    private int occupazione = 0;

    /**
     * Crea un oggetto portamonete contenente monete i cui valori sono specificati tramite argomenti variabili
     * (massimo dieci valori)
     * @param valori un array di dieci monete
     */
    public PortaMonete(int... valori) {
        int numeroMonete = valori.length;
        for (int i=0; i<numeroMonete; i++) {
            if (i >= 10) {
                System.out.println("Sono state inserite solo le prime 10 monete");
                break;
            }
            monete[i] = new Moneta(valori[i]);
            occupazione += 1;
        }
    }

    /**
     * Permette di aggiungere una moneta al portamonete se c'e' posto
     * @param m la moneta da aggiungere
     */
    public void aggiungi(Moneta m) {
        if (occupazione < 10) {
            monete[occupazione] = m;
            occupazione += 1;
        } else {
            System.out.println("Portamonete pieno, non e' possibile aggiungere ulteriori monete");
        }
    }

    /**
     * Permette di stampare su standard output il contenuto del portamonete
     */
    public void stato() {
        System.out.println("Il portamonete contiene: ");
        for (Moneta moneta : monete) {
            if (moneta == null) {
                break;
            }
            System.out.println("Una " + moneta.getDescrizione());
        }
    }

    /**
     * Permette di prelevare e rimuovere una moneta del valore richiesto dal portamonete
     * @param valore il valore della moneta richiesta
     * @return la moneta voluta
     */
    public Moneta preleva(int valore) {
        Moneta res = null;
        for (int i=0; i< monete.length; i++) {
            if (monete[i] == null) {
                break;
            }
            if (monete[i].getValore() == valore) {
                res = monete[i];
                monete[i] = monete[occupazione-1];
                monete[occupazione-1]=null;
                occupazione -= 1;
                break;
            }
        }
        if (res == null) {
            System.out.println("Non e' presente una moneta del valore voluto");
        }
        return res;
    }

}
