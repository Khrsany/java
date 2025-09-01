package tehtava_1;

// Car.java
public class Car implements Vehicle {
    private String color;

    public Car(String color) {
        this.color = color;
    }

    @Override
    public void start() {
        System.out.println("Car is starting...");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping...");
    }

    @Override
    public String getInfo() {
        return "Type: Car\n" +
                "Fuel: Petrol\n" +
                "Color: " + color;
    }
}