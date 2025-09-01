package tehtava_2;

public abstract class AbstractVehicle implements Vehicle {
    protected String fuelType;

    public AbstractVehicle(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public void start() {
        System.out.println("Vehicle is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Vehicle is stopping...");
    }

    public String getFuelType() {
        return fuelType;
    }

    @Override
    public abstract String getInfo();
}