package tehtava_2;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParallelSummation {

    public static void main(String[] args) {
        // 1. Alustetaan data: luodaan 100 miljoonan alkion taulukko ja täytetään se
        // satunnaisluvuilla (0-9).
        final int ARRAY_SIZE = 100_000_000;
        int[] numbers = new int[ARRAY_SIZE];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10);
        }

        // 2. Selvitetään käytettävissä olevien suoritinydinten määrä.
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Käytettävissä olevia suoritinytimiä: " + cores);
        System.out.println("Lasketaan summaa " + ARRAY_SIZE + " alkiolle...");

        // Aloitetaan ajanotto.
        long startTime = System.currentTimeMillis();

        // 3. Luodaan lista säikeitä varten ja jaetaan taulukko osiin.
        List<SumWorker> workers = new ArrayList<>();
        int sliceSize = ARRAY_SIZE / cores;

        for (int i = 0; i < cores; i++) {
            int start = i * sliceSize;
            // Varmistetaan, että viimeinen säie käsittelee kaikki loput alkiot,
            // jos taulukon koko ei ole jaollinen ydinten määrällä.
            int end = (i == cores - 1) ? ARRAY_SIZE : (i + 1) * sliceSize;

            // Luodaan uusi työntekijä (säie) ja käynnistetään se heti.
            SumWorker worker = new SumWorker(numbers, start, end);
            workers.add(worker);
            worker.start();
        }

        // 4. Odotetaan kaikkien säikeiden valmistumista ja kerätään tulokset.
        long totalSum = 0;
        try {
            for (SumWorker worker : workers) {
                // join() pysäyttää pääsäikeen, kunnes worker-säie on valmis.
                worker.join();
                // Lisätään valmiin säikeen osasumma kokonaissummaan.
                totalSum += worker.getPartialSum();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Lopetetaan ajanotto.
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        // 5. Tulostetaan lopputulos.
        System.out.println("\nLaskenta " + cores + " säikeellä:");
        System.out.println("Kokonaisaika: " + duration + " ms");
        System.out.println("Tulos: " + totalSum);
    }
}