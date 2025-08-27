public class FinalGroceryItem {
    private String name;
    private double cost;
    private String category;
    private int quantity;

    public FinalGroceryItem(String name, double cost, String category, int quantity) {
        this.name = name;
        this.cost = cost;
        this.category = category;
        this.quantity = quantity;
    }

    // getter ja setter metodit ei muutoksia toiminnass
    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }
}