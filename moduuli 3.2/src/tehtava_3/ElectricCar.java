package tehtava_3;

public class ElectricCar extends AbstractVehicle {
    private String color;

    public ElectricCar(String color) {
        super("Electricity");
        this.color = color;
    }

    @Override
    public String getInfo() {
        return "Type: Electric Car\n" +
                "Fuel: " + getFuelType() + "\n" +
                "Color: " + color;
    }

    @Override
    public void charge() {
        System.out.println("Electric Car is charging...");
    }
}