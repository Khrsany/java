package tehtava_3;

public class VehicleDemo3 {
    public static void main(String[] args) {
        System.out.println("Electric Vehicle Demonstration\n");

        ElectricCar eCar = new ElectricCar("Blue");
        eCar.start();
        eCar.stop();
        eCar.charge();
        System.out.println("Electric Car Information:\n" + eCar.getInfo() + "\n");

        Bus bus = new Bus(50);
        bus.start();
        bus.stop();
        bus.charge(); // Tämä kutsuu AbstractVehiclen oletustoteutuksen
        System.out.println("Bus Information:\n" + bus.getInfo());
    }
}