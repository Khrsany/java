package tehtava_1;

// VehicleDemo.java
public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        // Luodaan autot
        Vehicle car = new Car("Red");
        car.start();
        car.stop();
        System.out.println("Car Information:\n" + car.getInfo() + "\n");

        // Luodaan moottoripyörä
        Vehicle motorcycle = new Motorcycle("Black");
        motorcycle.start();
        motorcycle.stop();
        System.out.println("Motorcycle Information:\n" + motorcycle.getInfo() + "\n");

        // Luodaan bussi
        Vehicle bus = new Bus(40);
        bus.start();
        bus.stop();
        System.out.println("Bus Information:\n" + bus.getInfo());
    }
}