package tehtava_4;

public class Bus extends AbstractVehicle {
    private int capacity;

    public Bus(int capacity) {
        super("Diesel", 3.0);
        this.capacity = capacity;
    }

    @Override
    public String getInfo() {
        return "Type: Bus\n" +
                "Fuel: " + getFuelType() + "\n" +
                "Capacity: " + capacity + " passengers";
    }
}