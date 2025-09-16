package tehtava__2;

// Tämä on työntekijäluokka, jota käytetään testaamaan meidän
// ThreadSafeArrayList-luokkaa.
public class Worker implements Runnable {

    // Jokainen työntekijä tarvitsee pääsyn siihen samaan jaettuun listaan.
    private ThreadSafeArrayList safeList;

    // Konstruktorissa annetaan työntekijälle se lista, jota sen pitää muokata.
    public Worker(ThreadSafeArrayList safeList) {
        this.safeList = safeList;
    }

    // Tämän säie suorittaa, kun se käynnistetään.
    @Override
    public void run() {
        // Lisätään listaan 1000 uutta alkiota.
        // Jokainen alkio on uniikki tälle säikeelle.
        for (int i = 0; i < 1000; i++) {
            safeList.add(Thread.currentThread().getName() + "_" + i);
        }
    }
}