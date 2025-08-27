public class GroceryItem {
    private String name;
    private double cost;

    public GroceryItem(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    // Getter metodeilla saadaan haettua tuotteen nimi ja hinta
    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}