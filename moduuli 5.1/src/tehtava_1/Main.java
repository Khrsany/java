package tehtava_1;

public class Main {

    public static void main(String[] args) {
        final int MAX_NUMBER_TO_PRINT = 20;

        // 1. Luodaan "työnkuvat" (Runnable-oliot)
        Runnable oddNumberPrinter = new NumberPrinter(MAX_NUMBER_TO_PRINT, false); // false = ei ole parillinen, eli pariton
        Runnable evenNumberPrinter = new NumberPrinter(MAX_NUMBER_TO_PRINT, true);  // true = on parillinen

        // 2. Luodaan "työntekijät" (Thread-oliot) ja annetaan heille työt
        Thread oddThread = new Thread(oddNumberPrinter);
        Thread evenThread = new Thread(evenNumberPrinter);

        // 3. Nimetään työntekijät, jotta tuloste on selkeämpi
        oddThread.setName("Odd Thread");
        evenThread.setName("Even Thread");

        // 4. Käynnistetään säikeet. Tämä kutsuu niiden run()-metodeja.
        oddThread.start();
        evenThread.start();

        // 5. Odotetaan, että molemmat säikeet saavat työnsä valmiiksi
        // Muuten "Printing complete." tulostuisi heti.
        try {
            oddThread.join();  // Pääsäie odottaa tässä, kunnes oddThread on valmis
            evenThread.join(); // Pääsäie odottaa tässä, kunnes evenThread on valmis
        } catch (InterruptedException e) {
            System.err.println("A thread was interrupted.");
            Thread.currentThread().interrupt(); // Hyvä tapa käsitellä keskeytys
        }

        // 6. Tulostetaan loppuviesti
        System.out.println("Printing complete.");
    }
}