package tehtava_2;

public class SumWorker extends Thread {

    private final int[] array;
    private final int startIndex;
    private final int endIndex;
    private long partialSum; // long-tyyppiä ylivuodon välttämiseksi

    //Konstruktori SumWorker-säikeelle.
    //array Taulukko, josta summa lasketaan.
    //startIndex Laskennan aloitusindeksi.
    // endIndex Laskennan päättymisindeksi (tätä indeksiä ei lasketa mukaan).
    public SumWorker(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.partialSum = 0;
    }

    /**
     * Säikeen suorittama työ. Laskee summan määritellyltä osalta taulukkoa.
     */
    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            partialSum += array[i];
        }
    }

    /**
     * Palauttaa tämän säikeen laskeman osasumman.
     * @return Laskettu osasumma.
     */
    public long getPartialSum() {
        return partialSum;
    }
}