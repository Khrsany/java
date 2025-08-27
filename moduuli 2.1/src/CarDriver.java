public class CarDriver {
    public static void main(String[] args) {
        // Luodaan auto vanhalla tavalla kun tankki on 100
        Car toyota = new Car("Toyota Corolla");
        toyota.fillTank();
        System.out.println(toyota.getTypeName() + ", tankissa bensaa: " + toyota.getGasolineLevel() + " litraa.");

        // uusi tankin koko on 55
        Car ford = new Car("Ford Fiesta", 20.0, 55.0);
        ford.fillTank();
        System.out.println(ford.getTypeName() + ", tankissa bensaa: " + ford.getGasolineLevel() + " litraa.");
    }
}