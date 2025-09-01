package tehtava_4;

public abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected String fuelType;
    protected double fuelEfficiency;

    public AbstractVehicle(String fuelType, double fuelEfficiency) {
        this.fuelType = fuelType;
        this.fuelEfficiency = fuelEfficiency;
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
    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }

    @Override
    public void charge() {
        System.out.println("No possible to charge.");
    }
}