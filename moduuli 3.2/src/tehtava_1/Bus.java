package tehtava_1;

// Bus.java
public class Bus implements Vehicle {
    private int capacity;

    public Bus(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void start() {
        System.out.println("Bus is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Bus is stopping...");
    }

    @Override
    public String getInfo() {
        return "Type: Bus\n" +
                "Fuel: Diesel\n" +
                "Capacity: " + capacity + " passengers";
    }
}