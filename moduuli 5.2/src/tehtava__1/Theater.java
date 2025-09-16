package tehtava__1;

/**
 * Theater-luokka edustaa teatteria, jolla on rajallinen määrä paikkoja.
 * Tämä on jaettu resurssi, jota useat asiakassäikeet yrittävät käyttää.
 */
public class Theater {
    // Muuttuja, joka säilyttää vapaiden paikkojen määrän.
    // Tämä on se "jaettu, muutettava tila", joka vaatii synkronointia.
    private int availableSeats;

    /**
     * Konstruktori, jolla alustetaan teatterin paikkojen kokonaismäärä.
     * @param totalSeats Paikkojen määrä teatterissa.
     */
    public Theater(int totalSeats) {
        this.availableSeats = totalSeats;
        System.out.println("Teatteri luotu, paikkoja yhteensä: " + totalSeats);
    }

    /**
     * Metodi paikkojen varaamiseen.
     * Tämä metodi on synkronoitu, jotta vältetään kilpailutilanteet (race conditions).
     * 'synchronized'-avainsana varmistaa, että vain yksi säie voi suorittaa tätä
     * metodia kerrallaan samalle Theater-oliolle.
     *
     * @param numSeatsToReserve Varattavien paikkojen määrä.
     * @return 'true' jos varaus onnistui, 'false' jos paikkoja ei ollut tarpeeksi.
     */
    public synchronized boolean reserveSeats(int numSeatsToReserve) {
        // Haetaan nykyisen säikeen nimi, jotta tulosteet ovat selkeämpiä.
        String customerName = Thread.currentThread().getName();

        System.out.println(customerName + " yrittää varata " + numSeatsToReserve + " paikkaa. (Vapaita: " + availableSeats + ")");

        // Tarkistetaan, onko tarpeeksi paikkoja vapaana.
        if (availableSeats >= numSeatsToReserve) {
            // JOS TÄMÄ METODI EI OLISI SYNKRONOITU,
            // toinen säie voisi tulla tähän väliin, nähdä saman vapaiden paikkojen määrän
            // ja myydä samat paikat uudelleen!

            // Simuloidaan pientä viivettä (esim. tietokantakysely),
            // joka lisää kilpailutilanteen todennäköisyyttä ilman synkronointia.
            try {
                Thread.sleep(50); // 50 millisekunnin viive
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            // Vähennetään varatut paikat vapaiden paikkojen määrästä.
            availableSeats -= numSeatsToReserve;
            System.out.println("==> " + customerName + " ONNISTUI varaamaan " + numSeatsToReserve + " paikkaa. Paikkoja jäljellä: " + availableSeats);
            return true;
        } else {
            // Ei ollut tarpeeksi paikkoja, varaus epäonnistui.
            System.out.println("==> " + customerName + " EPÄONNISTUI. Ei tarpeeksi paikkoja (" + numSeatsToReserve + " yritetty, " + availableSeats + " vapaana).");
            return false;
        }
    }
}