package tehtava_4;

public class Motorcycle extends AbstractVehicle {
    private String color;

    public Motorcycle(String color) {
        super("Gasoline", 25.0);
        this.color = color;
    }

    @Override
    public String getInfo() {
        return "Type: Motorcycle\n" +
                "Fuel: " + getFuelType() + "\n" +
                "Color: " + color;
    }
}