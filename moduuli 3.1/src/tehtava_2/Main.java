package tehtava_2;

public class Main {
    public static void main(String[] args) {
        //tehhäään uusi bussi jonka kapasiteetti on 20 matkustajaa
        Bus localBus = new Bus("Paikallisliikenne", 20);

        System.out.println("--- Testataan matkustajien lisäämistä ---");
        localBus.passengerEnter(15); // oonnistuu
        localBus.passengerEnter(10); //epäonnistuu koska ylittää kapasiteetin
        localBus.passengerEnter(5);  // onnistuu koska tilaa on

        System.out.println("\n--- Testataan perittyjä ominaisuuksia ---");
        localBus.fillTank(); //tämä on Car luokalta peritty metodi
        localBus.accelerate(); //tämäki on peritty
        System.out.println("Bussin nopeus on nyt: " + localBus.getSpeed() + " km/h");

        System.out.println("\n--- Testataan matkustajien poistamista ---");
        localBus.passengerExit(8); //oonnistuu
        localBus.passengerExit(15); //epäonnistuu koska matkustajia ei ole tarpeeksi

        System.out.println("\nLopullinen matkustajamäärä: " + localBus.getPassengerCount());
    }
}