package tehtava_3;

public class ElectricMotorcycle extends AbstractVehicle {
    private String color;

    public ElectricMotorcycle(String color) {
        super("Electricity");
        this.color = color;
    }

    @Override
    public String getInfo() {
        return "Type: Electric Motorcycle\n" +
                "Fuel: " + getFuelType() + "\n" +
                "Color: " + color;
    }

    @Override
    public void charge() {
        System.out.println("Electric Motorcycle is charging...");
    }
}