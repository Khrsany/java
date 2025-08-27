public class CruiseControlCarDriver {

    public static void main(String[] args) {
        CruiseControlCar myCar = new CruiseControlCar("Volvo V60", 0, 70.0);
        myCar.fillTank();
        System.out.println(myCar.getTypeName() + " luotu ja tankattu.");

        System.out.println("\n--- Vakionopeudensäätimen testi ---");

        // tässä on tavoitenopeus
        myCar.setTargetSpeed(100.0);
        System.out.println("Tavoitenopeus asetettu arvoon: " + myCar.getTargetSpeed() + " km/h");

        //laitetaan säädin päällä ja tarkistetaan
        boolean success = myCar.turnCruiseControlOn();
        if (success) {
            System.out.println("Vakionopeudensäädin on nyt PÄÄLLÄ.");
            System.out.println("Auton nopeus on nyt: " + myCar.getSpeed() + " km/h");
        } else {
            System.out.println("Vakionopeudensäätimen kytkentä epäonnistui.");
        }

        // kun painaa kaasu säätimen pitäisi mennä pois päältä
        System.out.println("\nKuljettaja kiihdyttää manuaalisesti...");
        myCar.accelerate();
        System.out.println("Auton nopeus on nyt: " + myCar.getSpeed() + " km/h");

        // tarkistetaan onko säädin pois päältä
        if (!myCar.isCruiseControlOn()) {
            System.out.println("Vakionopeudensäädin on nyt POIS PÄÄLTÄ.");
        }
    }
}