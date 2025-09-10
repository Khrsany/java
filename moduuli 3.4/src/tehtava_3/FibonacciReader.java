package tehtava_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FibonacciReader {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("Fibonacci.csv");
             BufferedReader br = new BufferedReader(fr)) {

            //Otsikkorivin luku (ohitetaan käsittelystä)
            String header = br.readLine();
            if (header == null) {
                System.out.println("Tiedosto on tyhjä. (Otsikkorivi puuttuu)");
                return;
            }

            int    rowNo     = 1;   // 1 = otsikkorivi on luettu
            int    count     = 0;   // kelvollisten datarivien määrä
            int    lastIndex = -1;  // päivittyy viimeisellä kelvollisella rivillä
            long   sum       = 0;   // Value-sarakkeen summa (long, koska arvot kasvavat nopeasti)

            String line;
            while ((line = br.readLine()) != null) {
                rowNo++;

                String[] parts = line.split(";", 2);
                if (parts.length != 2) {
                    System.out.println("Virhe rivillä " + rowNo + ": sarakkeita ei ole kaksi.");
                    continue; // jatka seuraavaan riviin
                }

                //Trimmaa molemmat osat
                String indexStr = parts[0].trim();
                String valueStr = parts[1].trim();

                //Yritä jäsentää numerot
                int index;
                long value;
                try {
                    index = Integer.parseInt(indexStr);
                    value = Long.parseLong(valueStr);
                } catch (NumberFormatException nfe) {
                    System.out.println("Virhe rivillä " + rowNo + ": ei-numeerinen arvo (\""
                            + indexStr + "\"; \"" + valueStr + "\").");
                    continue;
                }

                // Kelvollinen rivi -> tulosta ja kerrytä yhteenvetoa
                System.out.println(index + " -> " + value);
                count++;
                lastIndex = index;
                sum += value;
            }

            //Yhteenveto
            System.out.println("------------------------------");
            System.out.println("Rivejä luettu (kelvolliset): " + count);
            if (count > 0) {
                System.out.println("Viimeinen indeksi: " + lastIndex);
            }
            System.out.println("Summa: " + sum);

        } catch (IOException e) {
            // Ystävällinen virheilmoitus, ei pinolokia
            System.out.println("Virhe tiedostoa luettaessa: " + e.getMessage());
        }
    }
}
