package tehtava_1;

// Tämä luokka on "työnkuva", jonka annamme säikeelle.
// Se sisältää ohjeet numeroiden tulostamiseen.
public class NumberPrinter implements Runnable {

    private final int maxNumber;
    private final boolean isEvenPrinter; // Kertoo, onko tämä parillisten vai parittomien tulostaja

    // Konstruktori, jolla annamme tiedot tulostajalle
    public NumberPrinter(int maxNumber, boolean isEvenPrinter) {
        this.maxNumber = maxNumber;
        this.isEvenPrinter = isEvenPrinter;
    }

    // run()-metodi sisältää varsinaisen työn, jonka säie suorittaa
    @Override
    public void run() {
        for (int i = 1; i <= maxNumber; i++) {
            // Tarkistetaan, vastaako numero tämän säikeen tehtävää
            if (isEvenPrinter && i % 2 == 0) { // Jos TÄMÄ on parillinen tulostaja JA numero on parillinen
                System.out.println(Thread.currentThread().getName() + ": " + i);
            } else if (!isEvenPrinter && i % 2 != 0) { // Jos TÄMÄ on pariton tulostaja JA numero on pariton
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}