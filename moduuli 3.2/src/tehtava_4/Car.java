package tehtava_4;

public class Car extends AbstractVehicle {
    private String color;

    public Car(String color) {
        super("Petrol", 12.5);
        this.color = color;
    }

    @Override
    public String getInfo() {
        return "Type: Car\n" +
                "Fuel: " + getFuelType() + "\n" +
                "Color: " + color;
    }
}