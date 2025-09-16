package tehtava__2;

// Testiluokka, jolla varmistetaan, että meidän ThreadSafeArrayList toimii.
public class Test {

    public static void main(String[] args) {

        // 1. Luodaan YKSI instanssi meidän turvallisesta listasta.
        // Tätä yhtä ja samaa listaa molemmat säikeet tulevat käyttämään.
        ThreadSafeArrayList sharedList = new ThreadSafeArrayList();

        // 2. Luodaan kaksi työntekijää ja annetaan niille sama lista.
        Worker worker1 = new Worker(sharedList);
        Worker worker2 = new Worker(sharedList);

        // 3. Tehdään työntekijöistä säikeet. Annetaan niille nimet, niin on kivempi seurata.
        Thread thread1 = new Thread(worker1, "Työntekijä-A");
        Thread thread2 = new Thread(worker2, "Työntekijä-B");

        System.out.println("Käynnistetään säikeet... Molemmat yrittävät lisätä 1000 alkiota.");

        // 4. Käynnistetään molemmat säikeet. Nyt alkaa kilpailu!
        thread1.start();
        thread2.start();

        // 5. Odotetaan, että molemmat säikeet saavat työnsä tehtyä.
        // Ilman join()-kutsuja pääohjelma jatkaisi heti eteenpäin
        // ja listan koko olisi todennäköisesti 0.
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            // Tulostetaan virhe, jos odotus keskeytyy.
            e.printStackTrace();
        }

        System.out.println("Säikeet ovat suorittaneet työnsä.");
        System.out.println("------------------------------------");

        // 6. Lopuksi tarkistetaan tulos.
        // Koska molemmat säikeet lisäsivät 1000 alkiota, lopputuloksen
        // PITÄÄ olla tasan 2000. Jos se on jotain muuta, synkronointi on epäonnistunut.
        System.out.println("Odotettu listan koko: 2000");
        System.out.println("Todellinen listan koko: " + sharedList.size());

        if (sharedList.size() == 2000) {
            System.out.println("Testi onnistui! Luokka on säieturvallinen.");
        } else {
            System.out.println("Testi epäonnistui! Jotain meni pieleen synkronoinnissa.");
        }
    }
}