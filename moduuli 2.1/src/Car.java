public class Car {
    // muuttujat
    private double speed;
    private double gasolineLevel;
    private String typeName;
    private double tankCapacity;

    //päivitetty tässä
    public Car(String typeName) {
        this.speed = 0;
        this.gasolineLevel = 0;
        this.typeName = typeName;
        //laitetaan oletuskapasiteetti, koska se ei ollu
        this.tankCapacity = 100.0;
    }

    //Uusi konstruktori jolla voi laittaa kapasiteettii ja alkunopeus
    public Car(String typeName, double initialSpeed, double capacity) {
        this.typeName = typeName;
        this.speed = initialSpeed;
        this.tankCapacity = capacity;
        this.gasolineLevel = 0; // aloitus on tyjältä tankilta
    }

    //tässä muutos: Tankataan auto täyteen. tällä: tankCapacity-arvoa.
    public void fillTank() {
        this.gasolineLevel = this.tankCapacity;
    }
    public void accelerate() {
        if (gasolineLevel > 0)
            speed += 10;
        else
            speed = 0;
    }

    public void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }

    public double getSpeed() {
        return speed;
    }

    public String getTypeName() {
        return typeName;
    }

    public double getGasolineLevel() {
        return gasolineLevel;
    }
}