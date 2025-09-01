package tehtava_2;

public class VehicleDemo2 {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration with Abstract Class\n");

        Vehicle car = new Car("Red");
        car.start();
        car.stop();
        System.out.println("Car Information:\n" + car.getInfo() + "\n");

        Vehicle motorcycle = new Motorcycle("Black");
        motorcycle.start();
        motorcycle.stop();
        System.out.println("Motorcycle Information:\n" + motorcycle.getInfo() + "\n");

        Vehicle bus = new Bus(40);
        bus.start();
        bus.stop();
        System.out.println("Bus Information:\n" + bus.getInfo());
    }
}