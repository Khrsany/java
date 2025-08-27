//pääohjelma, joka testaa CoffeeMaker luokan toimintaa.
public class CoffeeMakerDriver {
    public static void main(String[] args) {
        //Luodaan uusi olio
        CoffeeMaker myCoffeeMaker = new CoffeeMaker();

        //Kytketään päälle ja printataan
        myCoffeeMaker.pressOnOff();
        System.out.println("Coffee maker is on");

        //tyyppi on espresso ja määrä on 50 ml
        myCoffeeMaker.setCoffeeType("espresso");
        myCoffeeMaker.setCoffeeAmount(50);

        //printataan uudet asetukset: get-metodeja
        System.out.println("Coffee type is " + myCoffeeMaker.getCoffeeType());
        System.out.println("Coffee amount is " + myCoffeeMaker.getCoffeeAmount() + " ml");

        //laitetaan laite pois päältä
        myCoffeeMaker.pressOnOff();
        System.out.println("Coffee maker is off");
    }
}