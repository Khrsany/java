package tehtava__1;

/**
 * Customer-luokka toteuttaa Runnable-rajapinnan, joten sen ilmentymiä
 * voidaan suorittaa omina säikeinään. Jokainen asiakas yrittää varata
 * paikkoja annetusta teatterista.
 */
public class Customer implements Runnable {

    private Theater theater;
    private int seatsToReserve;

    /**
     * Konstruktori asiakkaalle.
     * @param theater        Viittaus jaettuun Theater-olioon.
     * @param seatsToReserve Kuinka monta paikkaa tämä asiakas yrittää varata.
     */
    public Customer(Theater theater, int seatsToReserve) {
        this.theater = theater;
        this.seatsToReserve = seatsToReserve;
    }

    @Override
    public void run() {
        // Kun säie käynnistyy, se suorittaa tämän metodin,
        // eli yrittää varata paikat.
        theater.reserveSeats(seatsToReserve);
    }
}