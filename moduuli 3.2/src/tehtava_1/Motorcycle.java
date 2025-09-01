package tehtava_1;

// Motorcycle.java
public class Motorcycle implements Vehicle {
    private String color;

    public Motorcycle(String color) {
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle is stopping...");
    }

    @Override
    public String getInfo() {
        return "Type: Motorcycle\n" +
                "Fuel: Gasoline\n" +
                "Color: " + color;
    }
}