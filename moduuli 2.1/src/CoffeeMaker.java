
public class CoffeeMaker {

    private boolean on;
    private String coffeeType;
    private int coffeeAmount;

    //Konstruktori asettaa kahvinkeittimelle oletusarvot,kun se luodaan.
    public CoffeeMaker() {
        this.on = false;
        this.coffeeType = "normal"; // Oletustyyppi
        this.coffeeAmount = 40;     // Oletusmäärä on välillä 10-80
    }

    //Kytkee virran päälle tai pois.
    public void pressOnOff() {
        this.on = !this.on;
    }


    //Asettaa kahvin tyypin. Toimii vain, jos laite on päällä.
    //Hyväksyy vain noi arvot normal ja espresso

    public void setCoffeeType(String type) {
        if (this.on) {
            if (type.equals("normal") || type.equals("espresso")) {
                this.coffeeType = type;
            }
        }
    }


     //laittaa kahvin määrä Toimii vaan jos laite on päällä
     //Hyväksyy vain arvot välillä 10-80 ml.

    public void setCoffeeAmount(int amount) {
        if (this.on) {
            if (amount >= 10 && amount <= 80) {
                this.coffeeAmount = amount;
            }
        }
    }

    //getter metodit, niillä voidaan kysyä laitteen tilaa.

    public boolean isOn() {
        return this.on;
    }

    public String getCoffeeType() {
        return this.coffeeType;
    }

    public int getCoffeeAmount() {
        return this.coffeeAmount;
    }
}