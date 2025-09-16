package tehtava__1;

/**
 * Main-luokka, joka käynnistää lippuvarausjärjestelmän simulaation.
 */
public class Main {

    public static void main(String[] args) {
        // 1. Luo yksi teatteri-olio, jossa on esimerkiksi 10 paikkaa.
        // Tämä on se YKSI resurssi, jota kaikki säikeet jakavat.
        Theater theater = new Theater(10);

        // 2. Luo useita asiakkaita (Runnable) ja kääri ne säikeiksi (Thread).
        // Annetaan säikeille nimet, jotta tulosteita on helpompi seurata.
        Thread customer1 = new Thread(new Customer(theater, 3), "Asiakas-1");
        Thread customer2 = new Thread(new Customer(theater, 4), "Asiakas-2");
        Thread customer3 = new Thread(new Customer(theater, 2), "Asiakas-3");
        Thread customer4 = new Thread(new Customer(theater, 2), "Asiakas-4"); // Pitäisi epäonnistua
        Thread customer5 = new Thread(new Customer(theater, 1), "Asiakas-5");

        // 3. Käynnistä kaikki säikeet.
        // .start() metodi käynnistää säikeen suorituksen ja kutsuu sen run()-metodia.
        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();
        customer5.start();

        // On hyvä käytäntö odottaa säikeiden suorituksen päättymistä
        // join()-metodilla, jos pääsäikeen tarvitsee tehdä jotain vasta
        // muiden säikeiden jälkeen. Tässä tapauksessa se ei ole välttämätöntä
        // toiminnallisuuden kannalta, mutta se varmistaa siistin lopetuksen.
        try {
            customer1.join();
            customer2.join();
            customer3.join();
            customer4.join();
            customer5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("------------------------------------");
        System.out.println("Kaikki varausyritykset tehty.");
    }
}