package tehtava_3;

public abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
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

    @Override
    public void charge() {
        System.out.println("No possible to charge.");
    }
}