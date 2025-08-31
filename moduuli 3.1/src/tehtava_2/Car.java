package tehtava_2;

public class Car {
    private double speed;
    private double gasolineLevel;
    private String typeName;

    //konstruktori perusautolle
    public Car(String typeName) {
        this.speed = 0;
        this.gasolineLevel = 0;
        this.typeName = typeName;
    }

    //hiihdytysmetodi
    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 10;
            gasolineLevel -= 1;
        } else {
            speed = 0;
        }
    }

    //hidastusmetodi
    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else {
            speed = 0;
        }
    }

    //getterit ja setterit
    double getSpeed() {
        return speed;
    }

    public void setSpeed(double newSpeed) {
        if (newSpeed >= 0) {
            this.speed = newSpeed;
        }
    }

    String getTypeName() {
        return typeName;
    }

    void fillTank() {
        gasolineLevel = 100;
    }

    double getGasolineLevel() {
        return gasolineLevel;
    }
}