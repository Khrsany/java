package tehtava_3;

public class Car extends AbstractVehicle {
    private String color;

    public Car(String color) {
        super("Petrol");
        this.color = color;
    }

    @Override
    public String getInfo() {
        return "Type: Car\n" +
                "Fuel: " + getFuelType() + "\n" +
                "Color: " + color;
    }
}