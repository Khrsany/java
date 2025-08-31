package tehtava_2;

public class Bus extends Car {

    // laitettaan pussille uusia omia ominaisuuksia.
    private int passengerCount;
    private final int capacity; //muista!! final tarkoittaa että kapasiteettia ei voi muuttaa luomisen jälkeen

    //kuonstruktori joka ottaa nimen ja kapasiteetin
    public Bus(String typeName, int capacity) {
        super(typeName); // kutsutaan yläluokan Carr konstruktoria
        this.capacity = capacity;
        this.passengerCount = 0; //bussi on aluksi tyhjä
    }

    // uusi vain bussille ominainen metodi
    public void passengerEnter(int count) {
        if (passengerCount + count <= capacity) {
            passengerCount += count;
            System.out.println(count + " matkustajaa astui sisään. Matkustajia yhteensä: " + passengerCount);
        } else {
            System.out.println("Virhe: " + count + " matkustajaa ei mahdu. Vain " + (capacity - passengerCount) + " paikkaa vapaana.");
        }
    }

    //toinen uusi metodi
    public void passengerExit(int count) {
        if (passengerCount - count >= 0) {
            passengerCount -= count;
            System.out.println(count + " matkustajaa poistui. Matkustajia yhteensä: " + passengerCount);
        } else {
            System.out.println("Virhe: Bussissa on vain " + passengerCount + " matkustajaa, " + count + " ei voi poistua.");
        }
    }

    //getteri matkustajamäärälle
    public int getPassengerCount() {
        return passengerCount;
    }
}