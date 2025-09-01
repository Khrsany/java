package tehtava_3;

public class Bus extends AbstractVehicle {
    private int capacity;

    public Bus(int capacity) {
        super("Diesel");
        this.capacity = capacity;
    }

    @Override
    public String getInfo() {
        return "Type: Bus\n" +
                "Fuel: " + getFuelType() + "\n" +
                "Capacity: " + capacity + " passengers";
    }
}