package mio;

/**
 * Astrae il concetto di Moneta. Moneta e' immutabile.
 */
public class Moneta {

    /**
     * La valuta e' una costante settata al valore EURO.
     */
    public final static String VALUTA = "EURO";

    /**
     * Rappresenta il valore della moneta in centesimi.
     */
    private final int valore;

    /**
     * Costruttore che prende in input il valore della moneta.
     *
     * @param valore il valore della moneta
     */
    Moneta(int valore) {
        this.valore = valore;
        System.out.println("Creata una " + getDescrizione());
    }

    private static String formattaStringaDescrittiva (int valore) {
        String stringaFormattata = " centesimi di ";
        if (valore == 1) {
            stringaFormattata = " centesimo di ";
        } else if (valore > 99){
            stringaFormattata = " ";
            valore /= 100;
        }
        return valore + stringaFormattata;
    }

    /**
     * Restituisce il valore della moneta
     */
    public int getValore() {
        return valore;
    }

    /**
     * Ritorna una descrizione della moneta corrente
     * @return descrizione della moneta corrente
     */
    public String getDescrizione() {
        return "moneta da " + formattaStringaDescrittiva(valore) + VALUTA;
    }

}
