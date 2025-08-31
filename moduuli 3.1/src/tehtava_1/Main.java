package tehtava_1;

public class Main {
    public static void main(String[] args) {
        // tehhään yksi tavallinen uauto ja yksi urheiluauto.
        Car tavallinenAuto = new Car("Toyota Avensis");
        SportsCar urheiluAuto = new SportsCar("Ferrari F40");

        //täytetään molempien tankit jotta ne voivat kiihtyä
        tavallinenAuto.fillTank();
        urheiluAuto.fillTank();

        System.out.println("--- Kiihdytetään kolme kertaa ---");

        //kkiihdytetään molempia autoja kolme kertaa ja tulostetaan nopueudet joka kerta.
        for (int i = 0; i < 3; i++) {
            tavallinenAuto.accelerate();
            urheiluAuto.accelerate();
            System.out.println(tavallinenAuto.getTypeName() + " nopeus: " + tavallinenAuto.getSpeed() + " km/h");
            System.out.println(urheiluAuto.getTypeName() + " nopeus: " + urheiluAuto.getSpeed() + " km/h");
            System.out.println(); // Tyhjä rivi
        }
    }
}