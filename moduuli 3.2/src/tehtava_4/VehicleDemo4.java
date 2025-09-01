package tehtava_4;

public class VehicleDemo4 {
    public static void main(String[] args) {
        System.out.println("Vehicle Fuel Efficiency Demonstration\n");

        Car car = new Car("Red");
        System.out.println("Car Fuel Efficiency: " + car.calculateFuelEfficiency() + " km/l\n");

        ElectricCar eCar = new ElectricCar("Blue");
        System.out.println("Electric Car Fuel Efficiency: " + eCar.calculateFuelEfficiency() + " kWh/km\n");

        Bus bus = new Bus(40);
        System.out.println("Bus Fuel Efficiency: " + bus.calculateFuelEfficiency() + " km/l\n");
    }
}