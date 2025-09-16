package tehtava__2;

import java.util.ArrayList;
import java.util.List;

// Tehdään tästä luokasta säieturvallinen versio ArrayListille.
// Tänne voi tallentaa Stringejä.
public class ThreadSafeArrayList {

    // Tämä on se lista, jota suojellaan.
    // Laitetaan se privateksi, ettei kukaan pääse käsiksi siihen ohi meidän metodien.
    private List<String> list = new ArrayList<>();

    /**
     * Lisätään uusi elementti listaan.
     * Tärkein juttu on 'synchronized', joka estää useampaa säiettä
     * suorittamasta tätä samaan aikaan. Ei tule sekaannuksia.
     */
    public synchronized void add(String element) {
        list.add(element);
    }

    /**
     * Poistetaan elementti listalta.
     * Myös tämän täytyy olla synchronized, koska listan muokkaaminen
     * poistamalla on yhtä vaarallista kuin lisääminen.
     */
    public synchronized boolean remove(String element) {
        return list.remove(element);
    }

    /**
     * Palauttaa listan koon.
     * Tämäkin on syytä synkronoida. Muuten voisi käydä niin, että toinen säie
     * on juuri lisäämässä alkiota, ja tämä metodi palauttaa vanhan koon,
     * koska lisäys ei ole vielä ihan valmis.
     */
    public synchronized int size() {
        return list.size();
    }

    // Pieni apumetodi, jolla voi kurkata listan sisältöä testausta varten.
    // Ei vaadittu tehtävänannossa, mutta kätevä.
    @Override
    public synchronized String toString() {
        return list.toString();
    }
}