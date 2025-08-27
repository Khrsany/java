public class CruiseControlCar {
    //metodit
    private double speed;
    private double gasolineLevel;
    private String typeName;
    private double tankCapacity;
    private double targetSpeed;
    private boolean cruiseControlOn;
    private static final double MIN_CRUISE_SPEED = 30.0;
    private static final double MAX_CRUISE_SPEED = 150.0;

    public CruiseControlCar(String typeName, double initialSpeed, double capacity) {
        this.typeName = typeName;
        this.speed = initialSpeed;
        this.tankCapacity = capacity;
        this.gasolineLevel = 0;

        this.cruiseControlOn = false;
        this.targetSpeed = 0;
    }

    public CruiseControlCar(String typeName) {
        this(typeName, 0, 100.0);
    }

    // UUDET NOPEUSSÄÄTIMET METODIT

    public void setTargetSpeed(double speed) {
        if (speed >= MIN_CRUISE_SPEED && speed <= MAX_CRUISE_SPEED) {
            this.targetSpeed = speed;
        }
    }

    public boolean turnCruiseControlOn() {
        if (gasolineLevel > 0 && targetSpeed >= MIN_CRUISE_SPEED) {
            this.cruiseControlOn = true;
            this.speed = this.targetSpeed;
            return true;
        }
        return false;
    }

    public void turnCruiseControlOff() {
        this.cruiseControlOn = false;
    }

    public double getTargetSpeed() {
        return this.targetSpeed;
    }

    public boolean isCruiseControlOn() {
        return this.cruiseControlOn;
    }

    //VANHAT METODIT
    public void accelerate() {
        turnCruiseControlOff();
        if (gasolineLevel > 0)
            speed += 10;
        else
            speed = 0;
    }

    public void decelerate(int amount) {
        turnCruiseControlOff();
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }

    public void fillTank() {
        this.gasolineLevel = this.tankCapacity;
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